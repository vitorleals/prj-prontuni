package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mb.HashMB;
import model.Medico;

@ManagedBean
@SessionScoped
public class MedicoDAO {

	@ManagedProperty("#{hashMB}")
	private HashMB hashMb;

	public List<Medico> lerTodos() {
		try {

			recuperaMap();

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

			recuperaMap();

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

		recuperaMap();
		
		System.out.println(medico);
		
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

	public void recuperaMap() {

		if (hashMb == null) {
			hashMb = new HashMB();
		}
	}

	public HashMB getHashMb() {
		return hashMb;
	}

	public void setHashMb(HashMB hashMb) {
		this.hashMb = hashMb;
	}
	
	

}
