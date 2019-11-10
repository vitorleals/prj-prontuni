package dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import model.Agendamento;

public class AgendamentoDAO extends JpaDAO<Agendamento> {

	public List<Agendamento> filtrar(Integer codUnidade) {

		try {

			String conector = " where ";
			String jpql = " top 100 from Agendamento a, Unidade u";

			jpql = jpql + conector + "a.status_agendamento = 'AGUARDANDO ATENDIMENTO'";

			if (codUnidade != null) {
				jpql = jpql + "AND" + " u.id_unidade= :codUnidade";

			}

			jpql = jpql + "order by a.data_inicio";

			TypedQuery<Agendamento> comando = this.getEntityManager().createQuery(jpql, Agendamento.class);


			if (codUnidade != null)
				comando.setParameter("codUnidade", codUnidade);

			return comando.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<Agendamento> filtrarDia() {

		try {
			
			CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Agendamento> c = cb.createQuery(Agendamento.class);
			c.select(c.from(Agendamento.class));

			List<Agendamento> resultado = this.getEntityManager().createQuery(c).getResultList();

			return resultado;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
