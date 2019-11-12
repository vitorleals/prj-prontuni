package dao;

import java.util.HashMap;
import java.util.Iterator;

import javax.persistence.NoResultException;

import model.Usuario;

public class UsuarioDAO {
	
	private HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
	
	public UsuarioDAO() {
		this.usuarios.put(1, instanciarUsuario("vitorls", "123456", "ESPECIALISTA"));
		//this.usuarios.put(1, instanciarUsuario("vitorls", "123456"));
	}

	public Usuario getUsuario(String login, String senha) {

		try {
			/*
			if (!this.getEntityManager().isOpen()) {

				getEntityManager();
			}
			String conector = " where ";
			String jpql = "from Usuario u";
			jpql = jpql + conector + " u.login = :login and u.senha = :senha";

			TypedQuery<Usuario> comando = this.getEntityManager().createQuery(jpql, Usuario.class);

			comando.setParameter("login", login);
			comando.setParameter("senha", senha);

			return comando.getSingleResult();
			*/
			Usuario user = new Usuario();
			
			Iterator<HashMap.Entry<Integer, Usuario>> iterator = this.usuarios.entrySet().iterator();
			
			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Usuario> userHash = iterator.next();
				if (userHash.getValue().getLogin().equals(login) && userHash.getValue().getSenha().equals(senha)) {
					user = userHash.getValue();
					break;
				}
			}

			return user;

		} catch (NoResultException e) {
			return null;
		} finally {
			//this.fecharConexao();
			//this.getEntityManager().close();
		}
	}
	
	private Usuario instanciarUsuario(String email, String senha, String tipoUsuario) {
		Usuario user = new Usuario();
		user.setLogin(email);
		user.setSenha(senha);
		user.setTipoUs(tipoUsuario);
		
		return user;
	}

}
