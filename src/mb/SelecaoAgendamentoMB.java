package mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.AgendamentoDAO;
import model.Agendamento;

@ManagedBean(name = "selecaoAgendamentoMB")
@ViewScoped
public class SelecaoAgendamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private SelecaoAgendamentoMB selAgendamentoMB;
	private Agendamento agendamento;
	private AgendamentoDAO agDao = null;
	private List<Agendamento> listAgendamentosFiltrados;
	private List<Agendamento> listAgendamentosTodos;
	private String palavra;
	
	
	
	public void pesquisar() {
		if (agDao == null) {
			abrirAgDAO();
		}
		//listAgendamentosFiltrados = agDao.porPalavra(palavra);
		fecharAgDAO();
	}

	public SelecaoAgendamentoMB getSelAgendamentoMB() {
		return selAgendamentoMB;
	}

	public void setSelAgendamentoMB(SelecaoAgendamentoMB selAgendamentoMB) {
		this.selAgendamentoMB = selAgendamentoMB;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public AgendamentoDAO getAgDao() {
		return agDao;
	}

	public void setAgDao(AgendamentoDAO agDao) {
		this.agDao = agDao;
	}

	public List<Agendamento> getListAgendamentosFiltrados() {
		return listAgendamentosFiltrados;
	}

	public void setListAgendamentosFiltrados(List<Agendamento> listAgendamentosFiltrados) {
		this.listAgendamentosFiltrados = listAgendamentosFiltrados;
	}

	public List<Agendamento> getListAgendamentosTodos() {
		return listAgendamentosTodos;
	}

	public void setListAgendamentosTodos(List<Agendamento> listAgendamentosTodos) {
		this.listAgendamentosTodos = listAgendamentosTodos;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void abrirAgDAO() {

		this.agDao = new AgendamentoDAO();

	};

	public void fecharAgDAO() {
		/*
		agDao.fecharConexao();
		agDao.getEntityManager().close();
		agDao = null;
		*/
	};

}
