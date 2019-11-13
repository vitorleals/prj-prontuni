package dao;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;

import mb.HashMB;
import model.Prontuario;

public class ProntuarioDAO{
	
	
	
	@Inject
	private HashMB hashMb = new HashMB();
	
	
	public void salvar(Prontuario prontuario) {
		HashMap<Integer, Prontuario> prontuarios = new HashMap<Integer, Prontuario>();
		Iterator<HashMap.Entry<Integer, Prontuario>> iterator = this.hashMb.getProntuarios().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Prontuario> prontuarioHash = iterator.next();
			if (prontuarioHash.getKey() != prontuario.getId_prontuario()) {
				prontuarios.put(prontuarioHash.getKey(), prontuarioHash.getValue());
			}
		}
		
		this.hashMb.setProntuarios(prontuarios);
		this.hashMb.addProntuario(prontuario.getId_prontuario(), prontuario);
	}
	
	
	
	
	public Prontuario lerPorId(Integer id) {
		Prontuario prontuario = new Prontuario();
		Iterator<HashMap.Entry<Integer, Prontuario>> iterator = this.hashMb.getProntuarios().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Prontuario> prontuarioHash = iterator.next();
			if (prontuarioHash.getKey() == id) {
				prontuario = prontuarioHash.getValue();
			}
		}
		
		return prontuario;
	}
	
	
	
	
	
	
	public Integer ultimoRegistro() {
		
		Integer ultimo = 1 + this.hashMb.getPacientes().size();
	
		
		return ultimo;	

	}

}
