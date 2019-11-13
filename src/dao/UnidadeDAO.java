package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import mb.HashMB;
import model.Unidade;

public class UnidadeDAO {
	
	@Inject
	private HashMB hashMb;
	
	public List<Unidade> lerTodos() {
		try {
			List<Unidade> unidades = new ArrayList<Unidade>();
			
			Iterator<HashMap.Entry<Integer, Unidade>> iterator = this.hashMb.getUnidades().entrySet().iterator();
			
			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Unidade> unidadeHash = iterator.next();
				unidades.add(unidadeHash.getValue());
			}
			
			return unidades;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Unidade lerPorId(Integer id) {
		Unidade unidade = new Unidade();
		Iterator<HashMap.Entry<Integer, Unidade>> iterator = this.hashMb.getUnidades().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Unidade> unidadeHash = iterator.next();
			if (unidadeHash.getKey() == id) {
				unidade = unidadeHash.getValue();
			}
		}
		
		return unidade;
	}

	public List<Unidade> porNomeSemelhante(String nome) {
		List<Unidade> unidades = new ArrayList<Unidade>();
		Iterator<HashMap.Entry<Integer, Unidade>> iterator = this.hashMb.getUnidades().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Unidade> unidadeHash = iterator.next();
			if (unidadeHash.getValue().getNome_unidade().contains(nome)) {
				unidades.add(unidadeHash.getValue());
			}
		}
		
		return unidades;
	}

}
