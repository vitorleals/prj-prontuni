package mb;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;

@Named
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO = null;
	private Usuario usuario;
	private String tipoUsuario;

	private String login;
	private String senha;

	private String loginCorreto;
	private String senhaCorreta;
	private boolean loggedIn;

	private Date data;

	public String home() {

		return "/restrito/atendimento/agenda.jsf?faces-redirect=true";

	}

	public String envia() {

		if (usuarioDAO == null) {
			abrirUsuDAO();
		}

		login.toLowerCase();
		usuario = usuarioDAO.getUsuario(login, senha);

		tipoUsuario = usuario.getTipoUs();
		loginCorreto = usuario.getLogin();
		senhaCorreta = usuario.getSenha();

		System.out.println(tipoUsuario);

		if ((usuario == null) || (!login.equals(loginCorreto) || !senha.equals(senhaCorreta))) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF ou senha incorretos!",
					"CPF ou senha incorretos!"));
			//fecharUsuDAO();
			return "index.jsf?faces-redirect=true";
		} else {
			loggedIn = true;
			//fecharUsuDAO();
			if (tipoUsuario.equals("ATENDIMENTO")) {
				return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
			}
			if (tipoUsuario.equals("ESPECIALISTA")) {
				return "/restrito/atendimento/agenda.jsf?faces-redirect=true";
			}
			if (tipoUsuario.equals("ADMIN")) {
				return "home.jsf?faces-redirect=true";
			}
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário sem permissões de acesso.",
					"Usuário sem permissões de acesso."));

			return null;
		}

	}

	public String acaoLogout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

		// encerrar a sessão atual
		session.invalidate();

		return "/index.jsf?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void abrirUsuDAO() {

		this.usuarioDAO = new UsuarioDAO();

	};

	public void fecharUsuDAO() {

		if (usuarioDAO.getEntityManager().isOpen()) {
		usuarioDAO.fecharConexao();
		usuarioDAO.getEntityManager().close();
		}
		usuarioDAO = null;

	}

	public String getLoginCorreto() {
		return loginCorreto;
	}

	public void setLoginCorreto(String loginCorreto) {
		this.loginCorreto = loginCorreto;
	}

	public String getSenhaCorreta() {
		return senhaCorreta;
	}

	public void setSenhaCorreta(String senhaCorreta) {
		this.senhaCorreta = senhaCorreta;
	};
}
