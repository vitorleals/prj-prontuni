package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mb.HashMB;
import model.Unidade;

@ManagedBean
@SessionScoped
public class UnidadeDAO {

	@ManagedProperty("#{hashMB}")
	private HashMB hashMb;

	public List<Unidade> lerTodos() {

		recuperaMap();

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

		recuperaMap();

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

		recuperaMap();

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
