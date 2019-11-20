package dao;

import java.util.HashMap;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mb.HashMB;
import model.Prontuario;

@ManagedBean
@SessionScoped
public class ProntuarioDAO {

	@ManagedProperty("#{hashMB}")
	private HashMB hashMb;

	public void salvar(Prontuario prontuario) {
		
		recuperaMap();
		
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
		
		recuperaMap();
		
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
		
		recuperaMap();

		Integer ultimo = 1 + this.hashMb.getPacientes().size();

		return ultimo;

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
