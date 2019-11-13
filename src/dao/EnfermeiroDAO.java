package dao;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;

import mb.HashMB;
import model.Agendamento;
import model.Enfermeiro;

public class EnfermeiroDAO {
	
	@Inject
	private HashMB hashMb;
	
	public void salvar(Enfermeiro enfermeiro) {
		HashMap<Integer, Enfermeiro> enfermeiros = new HashMap<Integer, Enfermeiro>();
		Iterator<HashMap.Entry<Integer, Enfermeiro>> iterator = this.hashMb.getEnfermeiros().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Enfermeiro> enfermeiroHash = iterator.next();
			if (enfermeiroHash.getKey() != enfermeiro.getId_pessoa()) {
				enfermeiros.put(enfermeiroHash.getKey(), enfermeiroHash.getValue());
			}
		}
		
		this.hashMb.setEnfermeiros(enfermeiros);
		this.hashMb.addEnfermeiro(enfermeiro.getId_pessoa(), enfermeiro);
	}

}
