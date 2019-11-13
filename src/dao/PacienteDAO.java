package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import mb.HashMB;
import model.Agendamento;
import model.Paciente;

public class PacienteDAO {
	
	@Inject
	private HashMB hashMb;

	public List<Paciente> porNomeSemelhante(String nome) {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		Iterator<HashMap.Entry<Integer, Paciente>> iterator = this.hashMb.getPacientes().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Paciente> pacienteHash = iterator.next();
			if (pacienteHash.getValue().getNome().contains(nome)) {
				pacientes.add(pacienteHash.getValue());
			}
		}
		
		return pacientes;	
	}
	
	public Paciente lerPorId(Integer id) {
		Paciente paciente = new Paciente();
		Iterator<HashMap.Entry<Integer, Paciente>> iterator = this.hashMb.getPacientes().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Paciente> pacienteHash = iterator.next();
			if (pacienteHash.getKey() == id) {
				paciente = pacienteHash.getValue();
			}
		}
		
		return paciente;
	}

	public Paciente lerPorCpf(String cpf) {
		try {
			Paciente paciente = new Paciente();
			
			Iterator<HashMap.Entry<Integer, Paciente>> iterator = this.hashMb.getPacientes().entrySet().iterator();
			
			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Paciente> pacienteHash = iterator.next();
				if (pacienteHash.getValue().getCpf().equals(cpf)) {
					paciente = pacienteHash.getValue();
				}
			}
			
			return paciente;	
		} catch (Exception e) {
			return null;
		}
	}

	/*
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
	*/
	
	public List<Paciente> lerTodos() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		Iterator<HashMap.Entry<Integer, Paciente>> iterator = this.hashMb.getPacientes().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Paciente> pacienteHash = iterator.next();
			pacientes.add(pacienteHash.getValue());
		}
		
		return pacientes;
	}
	
	public void excluir(Paciente paciente) {
		HashMap<Integer, Paciente> pacientes = new HashMap<Integer, Paciente>();
		
		Iterator<HashMap.Entry<Integer, Paciente>> iterator = this.hashMb.getPacientes().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Paciente> pacienteHash = iterator.next();
			if (pacienteHash.getKey() != paciente.getId_pessoa()) {
				pacientes.put(pacienteHash.getKey(), pacienteHash.getValue());
			}
		}
		
		this.hashMb.setPacientes(pacientes);
	}

}
