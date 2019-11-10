package mb;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UsuarioDAO;
import model.Pessoa;
import model.Usuario;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB {

	private Usuario usuario;
	private UsuarioDAO usuDao = null;
	private Pessoa pessoa;

	private String login;
	private String senha;
	private String tipoUsuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuDao() {
		return usuDao;
	}

	public void setUsuDao(UsuarioDAO usuDao) {
		this.usuDao = usuDao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String salvarUsuario() {

		Date data = new Date();
		this.usuario.setData_criacao(data);
		this.usuDao.salvar(this.usuario);

		return "index.jsf";
	}
	
	public String listarUsuario() {
		
		return "listarUsuarios.jsf";		
		
	}

	public String excluirUsuario(Integer codigo) {

		this.usuario = this.usuDao.lerPorId(codigo);
		this.usuDao.excluir(this.usuario);

		return listarUsuario();
	}
	
	public void abrirMedDAO() {

		this.usuDao = new UsuarioDAO();

	};

	public void fecharMedDAO() {

		usuDao.fecharConexao();
		usuDao.getEntityManager().close();
		usuDao = null;

	};

}
