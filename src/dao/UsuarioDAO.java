package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Usuario;

public class UsuarioDAO extends JpaDAO<Usuario> {

	public Usuario getUsuario(String login, String senha) {

		try {

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

		} catch (NoResultException e) {
			return null;
		} finally {
			this.fecharConexao();
			this.getEntityManager().close();
		}

	}

}
