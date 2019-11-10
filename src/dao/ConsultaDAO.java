package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Consulta;
import model.Prontuario;

public class ConsultaDAO extends JpaDAO<Consulta> {

	public List<Consulta> lerPorProntuario(Prontuario codigo) {

		String conector = " where ";
		String jpql = "from Consulta c";

		if (codigo != null) {
			jpql = jpql + conector + " consultas_pront = :codigo";
			
		}
		
		TypedQuery<Consulta> comando = this.getEntityManager().createQuery(jpql, Consulta.class).setParameter("codigo",codigo);

		return comando.getResultList();

	}
}
