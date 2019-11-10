package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Unidade;

public class UnidadeDAO extends JpaDAO<Unidade> {

	public List<Unidade> porNomeSemelhante(String nome) {

		String jpql = "from Unidade where nome_unidade like :nome";

		jpql = jpql + "  order by nome_unidade";

		TypedQuery<Unidade> comando = this.getEntityManager().createQuery(jpql, Unidade.class).setParameter("nome",
				"%" + nome + "%");

		return comando.getResultList();

	}

}
