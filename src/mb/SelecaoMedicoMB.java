package mb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import dao.MedicoDAO;
import model.Medico;

@ManagedBean(name = "selecaoMedicoMB")
@ViewScoped
public class SelecaoMedicoMB {

	private static final long serialVersionUID = 1L;

	private MedicoDAO medicoDAO = null;

	private Medico medico;

	private String nome;

	private List<Medico> medicosFiltrados;
	
	@PostConstruct
	public void init() {

		if (medicoDAO == null) {

			abrirMedDAO();
		}
		nome = "";
		medicosFiltrados = medicoDAO.porNomeSemelhante(nome);
		fecharMedDAO();
	}

	// GETTERS AND SETTERS
	public MedicoDAO getMedicoDAO() {
		return medicoDAO;
	}

	public void setMedicoDAO(MedicoDAO medicoDAO) {
		this.medicoDAO = medicoDAO;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

		this.medicoDAO = new MedicoDAO();

	};

	public void fecharMedDAO() {
		/*
		medicoDAO.fecharConexao();
		medicoDAO.getEntityManager().close();
		medicoDAO = null;
		*/
	};

}
