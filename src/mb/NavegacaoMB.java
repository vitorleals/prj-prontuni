package mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navMB")
@SessionScoped
public class NavegacaoMB implements Serializable {

	private static final long serialVersionUID = -8071218147945794962L;
	private NavegacaoMB navMB;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String homeAtendimento() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
	}
	
	public String paginaListaAgendamento() {

		return "/restrito/atendimento/buscarAgendamento.jsf?faces-redirect=true";
	}

	public String homeEspecialista() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
	}

	public String listarConsultas() {

		return "/restrito/atendimento/agendarConsulta.jsf?faces-redirect=true";
	}

	public String homeAdministrador() {

		return "/restrito/atendimento/agendarConsulta.jsf?faces-redirect=true";
	}

	public String agendarConsulta() {

		return "/restrito/atendimento/agendarConsulta.jsf?faces-redirect=true";
	}

	public String paginaInicial() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
	}

	public String paginaCalendario() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
	}

	public String pagNovoAgendamento() {

		return "/restrito/atendimento/agendarConsulta.jsf?faces-redirect=true";
	}

	public String novoAgendamento() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
	}

	public String acaoCadastroPaciente() {

		return "/restrito/paciente/editarPaciente.jsf?faces-redirect=true";
	}

	public String acaoListarPaciente() {
		return "/restrito/paciente/listarPaciente.jsf?faces-redirect=true";
	}

	public String paginaDashboard() {

		return "/restrito/relatorios/dashboard.jsf?faces-redirect=true";
	}

	public String paginaRealizarConsulta() {

		return "/restrito/paciente/editarPaciente.jsf?faces-redirect=true";
	}

	public String paginaMinhaConta() {

		return "/restrito/paciente/editarPaciente.jsf?faces-redirect=true";
	}

	public NavegacaoMB getNavMB() {
		return navMB;
	}

	public void setNavMB(NavegacaoMB navMB) {
		this.navMB = navMB;
	}

}
