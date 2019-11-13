package mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import dao.PacienteDAO;
import model.Paciente;

@ManagedBean(name = "selecaoPacienteMB")
@ViewScoped
public class SelecaoPacienteMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SelecaoPacienteMB selPacMB;
	private PacienteDAO pacienteDAO = null;
	private Paciente paciente;
	private String nome;
	private String codProntuario;
	private List<Paciente> pacientesFiltrados;

	@PostConstruct
	public void init() {

		if (pacienteDAO == null) {

			abrirPacDAO();
		}
		nome = "";
		pacientesFiltrados = pacienteDAO.porNomeSemelhante(nome);
		fecharPacDAO();
	}

	public void pesquisar() {
		if (pacienteDAO == null) {

			abrirPacDAO();
		}
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientesFiltrados() {
		return pacientesFiltrados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getCodProntuario() {
		return codProntuario;
	}

	public void setCodProntuario(String codProntuario) {
		this.codProntuario = codProntuario;
	}

	public SelecaoPacienteMB getSelPacMB() {
		return selPacMB;
	}

	public void setSelPacMB(SelecaoPacienteMB selPacMB) {
		this.selPacMB = selPacMB;
	}

	public void abrirPacDAO() {

		this.pacienteDAO = new PacienteDAO();

	};

	public void fecharPacDAO() {
		/*
		pacienteDAO.fecharConexao();
		pacienteDAO.getEntityManager().close();
		pacienteDAO = null;
		*/
	};

}
