package mb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.MedicoDAO;
import model.Medico;

@ManagedBean(name = "medicoMB")
@SessionScoped
public class MedicoMB {

	private Medico medico = new Medico();
	private MedicoDAO dao;
	private Date data;
	
	@PostConstruct
	public void init() {
		
		dao = new MedicoDAO();
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
			this.dao.salvar(medico);
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

}
