package mb;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;

import dao.PacienteDAO;
import dao.ProntuarioDAO;
import model.Paciente;
import model.Prontuario;

@ManagedBean(name = "pacienteMB")
@SessionScoped
public class PacienteMB {

	private Paciente paciente = new Paciente();
	private PacienteDAO pacienteDAO = null;
	private Prontuario prontu = new Prontuario();
	private ProntuarioDAO prontDAO = null;
	private List<Paciente> listPacientes;

	private Date data;

	private boolean skip;
	private Integer pacienteId;
	private String pront;
	private String numeroProntuario;
	private String nome;

	private String codProntuario;
	private List<Paciente> pacientesFiltrados;

	/*
	 * 
	 * METODOS GETTERS AND SETTERS
	 * 
	 */
	@PostConstruct
	public void init() {

		if (pacienteDAO == null) {
			abrirPacDAO();
		}

		nome = "";
		listPacientes = pacienteDAO.porNomeSemelhante(nome);
		pacientesFiltrados = pacienteDAO.porNomeSemelhante(nome);

		fecharPacDAO();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPront() {
		return pront;
	}

	public void setPront(String pront) {
		this.pront = pront;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public ProntuarioDAO getProntDao() {
		return prontDAO;
	}

	public void setProntDao(ProntuarioDAO prontDao) {
		this.prontDAO = prontDao;
	}

	/*
	 * 
	 * OUTROS METODOS
	 * 
	 */

	public void pesquisar() {
		if (pacienteDAO == null) {

			abrirPacDAO();
		}
		listPacientes = pacienteDAO.porNomeSemelhante(nome);
		pacientesFiltrados = pacienteDAO.porNomeSemelhante(nome);
		fecharPacDAO();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("/restrito/paciente/selecaoPaciente", opcoes, null);
	}

	public void selecionar(Paciente paciente) {
		PrimeFaces.current().dialog().closeDynamic(paciente);
	}

	public Prontuario getProntu() {
		return prontu;
	}

	public void setProntu(Prontuario prontu) {
		this.prontu = prontu;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public ProntuarioDAO getProntDAO() {
		return prontDAO;
	}

	public void setProntDAO(ProntuarioDAO prontDAO) {
		this.prontDAO = prontDAO;
	}

	public String getNumeroProntuario() {
		return numeroProntuario;
	}

	public void setNumeroProntuario(String numeroProntuario) {
		this.numeroProntuario = numeroProntuario;
	}

	public String acaoCadastroPaciente() {

		this.paciente = new Paciente();

		return "/restrito/paciente/editarPaciente.jsf?faces-redirect=true";
	}

	public String acaoListarPaciente() {
		return "/restrito/paciente/listarPaciente.jsf?faces-redirect=true";
	}

	public String acaoAbrirAlteracao(Integer codigo) {
		if (pacienteDAO == null) {
			abrirPacDAO();
		}
		this.paciente = this.pacienteDAO.lerPorId(codigo);

		fecharPacDAO();

		return "/restrito/paciente/editarPaciente.jsf?faces-redirect=true";
	}

	public void acaoSalvar() {

		// salvarPaciente();
		// geraProntuario(paciente);
	}

	public String salvarPaciente() {
		try {

			if (prontDAO == null) {
				abrirProntDAO();
			}

			if (pacienteDAO == null) {
				abrirPacDAO();
			}

			// Paciente
			Date data = new Date();
			this.paciente.setData_criacao(data);
			this.paciente.setNum_prontuario(prontu);
			// this.dao.salvar(paciente); ;;; Comentado porque estava duplicando na hora de
			// salvar... só o DAO de Prontuario resolve
			System.out.println(paciente);

			if (this.paciente.getId_pessoa() == null) {
				// Prontuario
				String pront = geraProntuario();

				if (prontDAO == null) {
					abrirProntDAO();
				}

				this.prontu.setData_criacao(data);
				this.prontu.setCod_prontuario(pront);
				this.prontu.setPaciente(paciente);
				this.prontu.setUltima_atualizacao(data);
				// this.prontDAO.salvar(prontu);

			}

			this.prontDAO.salvar(prontu);
			this.pacienteDAO.salvar(paciente);

			nome = "";
			listPacientes = pacienteDAO.porNomeSemelhante(nome);

			// fecharProntDAO();
			// fecharPacDAO();

			this.paciente = null;

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Paciente cadastrado com sucesso!"));

			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			return "/restrito/paciente/listarPaciente.jsf?faces-redirect=true";

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao cadastrar paciente."));

			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		}

		return null;
	}

	public String acaoExcluir(Integer codigo) {
		if (pacienteDAO == null) {
			abrirPacDAO();
		}
		paciente = this.pacienteDAO.lerPorId(codigo);
		this.pacienteDAO.excluir(paciente);

		nome = "";
		listPacientes = pacienteDAO.porNomeSemelhante(nome);

		fecharPacDAO();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso!", "Paciente excluido com sucesso!"));

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		return "/restrito/paciente/listarPaciente.jsf?faces-redirect=true";
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public String ultimoRegistro() {
		if (prontDAO == null) {
			abrirProntDAO();
		}
		Integer resultado = prontDAO.ultimoRegistro();
		numeroProntuario = resultado.toString();

		if (numeroProntuario.isEmpty()) {
			numeroProntuario = "1";
		}

		fecharProntDAO();

		return numeroProntuario;
	}

	public String geraProntuario() {
		ultimoRegistro();
		pront = "P1000" + numeroProntuario;

		return pront;
	}

	public void abrirPacDAO() {

		this.pacienteDAO = new PacienteDAO();

	};

	public void fecharPacDAO() {
		/*
		 * if (pacienteDAO.getEntityManager().isOpen()) { pacienteDAO.fecharConexao();
		 * pacienteDAO.getEntityManager().close(); }
		 * 
		 * pacienteDAO = null;
		 */
	};

	public void abrirProntDAO() {

		this.prontDAO = new ProntuarioDAO();

	};

	public void fecharProntDAO() {
		/*
		 * if (prontDAO.getEntityManager().isOpen()) { prontDAO.fecharConexao();
		 * prontDAO.getEntityManager().close(); }
		 * 
		 * prontDAO = null;
		 */
	}

	public List<Paciente> getListPacientes() {
		return listPacientes;
	}

	public void setListPacientes(List<Paciente> listPacientes) {
		this.listPacientes = listPacientes;
	}

	public String getCodProntuario() {
		return codProntuario;
	}

	public void setCodProntuario(String codProntuario) {
		this.codProntuario = codProntuario;
	}

	public List<Paciente> getPacientesFiltrados() {
		return pacientesFiltrados;
	}

	public void setPacientesFiltrados(List<Paciente> pacientesFiltrados) {
		this.pacientesFiltrados = pacientesFiltrados;
	};

}
