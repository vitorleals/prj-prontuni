package dao;

import javax.persistence.TypedQuery;

import model.Prontuario;

public class ProntuarioDAO extends JpaDAO<Prontuario> {

	
	
	public Integer ultimoRegistro() {

		String jpql = "select max(id_prontuario) from Prontuario";

		//jpql = jpql + "  order by nome";

		TypedQuery<Integer> comando = this.getEntityManager().createQuery(jpql, Integer.class);
			
		return comando.getSingleResult();

	}

}
