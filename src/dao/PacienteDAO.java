package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Paciente;

public class PacienteDAO extends JpaDAO<Paciente> {

	public List<Paciente> porNomeSemelhante(String nome) {

		String jpql = "from Paciente where nome like :nome";

		jpql = jpql + "  order by nome";

		TypedQuery<Paciente> comando = this.getEntityManager().createQuery(jpql, Paciente.class).setParameter("nome",
				"%" + nome + "%");

		return comando.getResultList();

	}

	public Paciente lerPorCpf(String cpf) {

		try {
			String jpql = "from Cliente p where p.cpf= :cpf";
			TypedQuery<Paciente> comando = this.getEntityManager().createQuery(jpql, Paciente.class);
			comando.setParameter("cpf", cpf);
			return (Paciente) comando.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public List<Paciente> listar(Integer matricula, String nome) {

		String jpql = "from Paciente p";

		if (matricula != null)
			jpql = jpql + "  where p.matricula like :matricula";

		if (nome != null) {
			jpql = jpql + "where" + " p.nome = :nome";

		}

		jpql = jpql + "  order by p.nome";

		TypedQuery<Paciente> comando = this.getEntityManager().createQuery(jpql, Paciente.class);

		return comando.getResultList();

	}

}
