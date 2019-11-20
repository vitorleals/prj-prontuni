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

import dao.MedicoDAO;
import model.Medico;

@ManagedBean(name = "medicoMB")
@SessionScoped
public class MedicoMB {

	private Medico medico = new Medico();
	private MedicoDAO dao;
	private Date data;

	private MedicoDAO medicoDAO = null;

	// private Medico medico;

	private String nome;

	private List<Medico> medicosFiltrados;

	@PostConstruct
	public void init() {

		if (medicoDAO == null) {

			abrirMedDAO();
		}

		fecharMedDAO();
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public MedicoDAO getMedDao() {
		return dao;
	}

	public void setMedDao(MedicoDAO dao) {
		this.dao = dao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String acaoSalvar() {

		try {

			Date data = new Date();
			this.medico.setData_criacao(data);
			this.medicoDAO.salvar(medico);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro realizado com sucesso!"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Falha ao realizar o cadastro."));
		}

		return null;
	}

	public String acaoCancelar() {

		return null;

	}

	// MÉTODOS PARA SELECIONAR MEDICOS
	public void pesquisar() {
		if (medicoDAO == null) {

			abrirMedDAO();
		}
		medicosFiltrados = medicoDAO.porNomeSemelhante(nome);
		fecharMedDAO();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("draggable", false);
		opcoes.put("closable", true);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("/restrito/medico/selecaoMedico", opcoes, null);
	}

	public void selecionar(Medico medico) {
		PrimeFaces.current().dialog().closeDynamic(medico);

	}

	public void abrirMedDAO() {

		medicoDAO = new MedicoDAO();

	};

	public void fecharMedDAO() {
		/*
		 * medicoDAO.fecharConexao(); medicoDAO.getEntityManager().close(); medicoDAO =
		 * null;
		 */
	};

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Medico> getMedicosFiltrados() {
		return medicosFiltrados;
	}

	public void setMedicosFiltrados(List<Medico> medicosFiltrados) {
		this.medicosFiltrados = medicosFiltrados;
	}

}
