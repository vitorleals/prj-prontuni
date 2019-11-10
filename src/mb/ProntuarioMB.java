package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ConsultaDAO;
import dao.PacienteDAO;
import dao.ProntuarioDAO;
import model.Consulta;
import model.Paciente;
import model.Prontuario;

@SessionScoped
@ManagedBean(name = "prontuarioMB")
public class ProntuarioMB {

	private Prontuario prontuario;
	private ProntuarioDAO prontDAO = new ProntuarioDAO();
	private String numeroProntuario;
	private String pront;
	private List<Consulta> historicoConsulta;
	private Paciente paciente;
	private PacienteDAO pacDAO = null;
	private Consulta consultaSelecionada;
	private ConsultaDAO conDao = null;

	public ConsultaDAO getConDao() {
		return conDao;
	}

	public void setConDao(ConsultaDAO conDao) {
		this.conDao = conDao;
	}

	@PostConstruct
	public void init() {

	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
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

	public String getPront() {
		return pront;
	}

	public void setPront(String pront) {
		this.pront = pront;
	}

	public String ultimoRegistro() {
		Integer resultado = prontDAO.ultimoRegistro();
		numeroProntuario = resultado.toString();
		return numeroProntuario;
	}

	public String geraProntuario() {
		ultimoRegistro();
		pront = "P000" + numeroProntuario;

		return pront;
	}

	public List<Consulta> getHistoricoConsulta() {
		return historicoConsulta;
	}

	public void setHistoricoConsulta(List<Consulta> historicoConsulta) {
		this.historicoConsulta = historicoConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteDAO getPacDAO() {
		return pacDAO;
	}

	public void setPacDAO(PacienteDAO pacDAO) {
		this.pacDAO = pacDAO;
	}

	public Consulta getConsultaSelecionada() {
		return consultaSelecionada;
	}

	public void setConsultaSelecionada(Consulta consultaSelecionada) {
		this.consultaSelecionada = consultaSelecionada;
	}

	public void buscarHistorico(Integer codigo) {

		 prontuario = prontDAO.lerPorId(codigo);

		if (conDao == null) {
			abrirConDAO();
		}

		historicoConsulta = conDao.lerPorProntuario(prontuario);
		
		fecharConDAO();
		
		
		
	}
	
	public String pagProntuario() {
		
		return "/prontuniTCC/restrito/consulta/detalheProntuario.jsf?faces-redirect=true";
		
	}

	public void abrirProntDAO() {

		this.prontDAO = new ProntuarioDAO();

	};

	public void fecharProntDAO() {
		if (prontDAO.getEntityManager().isOpen()) {
			prontDAO.fecharConexao();
			prontDAO.getEntityManager().close();
		}

		prontDAO = null;

	}

	public void abrirPacDAO() {

		this.pacDAO = new PacienteDAO();

	};

	public void fecharPacDAO() {
		if (pacDAO.getEntityManager().isOpen()) {
			pacDAO.fecharConexao();
			pacDAO.getEntityManager().close();
		}

		pacDAO = null;

	};

	public void abrirConDAO() {

		this.conDao = new ConsultaDAO();

	};

	public void fecharConDAO() {

		if (conDao.getEntityManager().isOpen()) {
			conDao.fecharConexao();
			conDao.getEntityManager().close();
			conDao = null;
		}
	};

}
