package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import mb.HashMB;
import model.Agendamento;
import model.Enfermeiro;
import model.Medico;

public class MedicoDAO {
	
	@Inject
	private HashMB hashMb;
	
	public List<Medico> lerTodos() {
		try {
			List<Medico> medicos = new ArrayList<Medico>();
			
			Iterator<HashMap.Entry<Integer, Medico>> iterator = this.hashMb.getMedicos().entrySet().iterator();
			
			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Medico> medicoHash = iterator.next();
				medicos.add(medicoHash.getValue());
			}
			
			return medicos;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Medico> porNomeSemelhante(String nome) {
		try {
			List<Medico> medicos = new ArrayList<Medico>();
			
			Iterator<HashMap.Entry<Integer, Medico>> iterator = this.hashMb.getMedicos().entrySet().iterator();
			
			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Medico> medicoHash = iterator.next();
				if (medicoHash.getValue().getNome().contains(nome)) {
					medicos.add(medicoHash.getValue());
				}
			}
			
			return medicos;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void salvar(Medico medico) {
		HashMap<Integer, Medico> medicos = new HashMap<Integer, Medico>();
		Iterator<HashMap.Entry<Integer, Medico>> iterator = this.hashMb.getMedicos().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Medico> medicoHash = iterator.next();
			if (medicoHash.getKey() != medico.getId_pessoa()) {
				medicos.put(medicoHash.getKey(), medicoHash.getValue());
			}
		}
		
		this.hashMb.setMedicos(medicos);
		this.hashMb.addMedico(medico.getId_pessoa(), medico);
	}

}
