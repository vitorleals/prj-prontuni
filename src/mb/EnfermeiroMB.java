package mb;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.EnfermeiroDAO;
import model.Enfermeiro;

@ManagedBean(name = "enfermeiroMB")
@RequestScoped
public class EnfermeiroMB {

	private Enfermeiro enfermeiro = new Enfermeiro();
	private EnfermeiroDAO dao = new EnfermeiroDAO();
	private Date data;

	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public EnfermeiroDAO getMedDao() {
		return dao;
	}

	public void setMedDao(EnfermeiroDAO dao) {
		this.dao = dao;
	}

	public String acaoSalvar() {

		try {

			Date data = new Date();
			this.enfermeiro.setData_criacao(data);
			this.dao.salvar(enfermeiro);
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
