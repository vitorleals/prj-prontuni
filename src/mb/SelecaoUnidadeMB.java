package mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import dao.UnidadeDAO;
import model.Unidade;

@ManagedBean(name = "selecaoUnidadeMB")
@ViewScoped
public class SelecaoUnidadeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private SelecaoUnidadeMB selUnidadeMB;
	private Unidade unidade;
	private UnidadeDAO uniDao = null;
	private List<Unidade> listUnidadesFiltrados;
	private List<Unidade> listUnidadesTodos;
	private String nome;

	@PostConstruct
	public void init() {

		if (uniDao == null) {
			abrirUniDAO();
		}
		nome = "";
		setListUnidadesTodos(uniDao.lerTodos());
		fecharUniDAO();

	}

	public void pesquisar() {
		if (uniDao == null) {
			abrirUniDAO();
		}
		listUnidadesFiltrados = uniDao.porNomeSemelhante(nome);
		fecharUniDAO();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		PrimeFaces.current().dialog().openDynamic("/restrito/consulta/selecaoUnidade", opcoes, null);
	}

	public void selecionar(Unidade unidade) {
		PrimeFaces.current().dialog().closeDynamic(unidade);
	}

	public SelecaoUnidadeMB getSelUnidadeMB() {
		return selUnidadeMB;
	}

	public void setSelUnidadeMB(SelecaoUnidadeMB selUnidadeMB) {
		this.selUnidadeMB = selUnidadeMB;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UnidadeDAO getUniDao() {
		return uniDao;
	}

	public void setUniDao(UnidadeDAO uniDao) {
		this.uniDao = uniDao;
	}

	public List<Unidade> getListUnidadesFiltrados() {
		return listUnidadesFiltrados;
	}

	public void setListUnidadesFiltrados(List<Unidade> listUnidadesFiltrados) {
		this.listUnidadesFiltrados = listUnidadesFiltrados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void abrirUniDAO() {

		this.uniDao = new UnidadeDAO();

	};

	public void fecharUniDAO() {
		/*
		uniDao.fecharConexao();
		uniDao.getEntityManager().close();
		uniDao = null;
		*/
	}

	public List<Unidade> getListUnidadesTodos() {
		return listUnidadesTodos;
	}

	public void setListUnidadesTodos(List<Unidade> listUnidadesTodos) {
		this.listUnidadesTodos = listUnidadesTodos;
	};

}
