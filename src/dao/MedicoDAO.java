package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Medico;

public class MedicoDAO extends JpaDAO<Medico> {

	public List<Medico> porNomeSemelhante(String nome) {

		String jpql = "from Medico where nome like :nome";

		TypedQuery<Medico> comando = this.getEntityManager().createQuery(jpql, Medico.class).setParameter("nome",
				"%" + nome + "%");

		return comando.getResultList();

	}

}
