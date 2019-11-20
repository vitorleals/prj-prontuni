package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mb.HashMB;
import model.Agendamento;

@ManagedBean
@SessionScoped
public class AgendamentoDAO {

	@ManagedProperty("#{hashMB}")
	private HashMB hashMb;

	public List<Agendamento> lerTodos() {

		recuperaMap();

		List<Agendamento> agendamentos = new ArrayList<Agendamento>();

		Iterator<HashMap.Entry<Integer, Agendamento>> iterator = this.hashMb.getAgendamentos().entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Agendamento> agendamentoHash = iterator.next();
			agendamentos.add(agendamentoHash.getValue());
		}

		return agendamentos;
	}

	public List<Agendamento> filtrar(Integer codUnidade) {
		
		recuperaMap();
		
		try {
			List<Agendamento> agendamentos = new ArrayList<Agendamento>();

			Iterator<HashMap.Entry<Integer, Agendamento>> iterator = this.hashMb.getAgendamentos().entrySet()
					.iterator();

			while (iterator.hasNext()) {
				HashMap.Entry<Integer, Agendamento> agendamentoHash = iterator.next();
				if (agendamentoHash.getValue().getUnidade().equals(codUnidade)) {
					agendamentos.add(agendamentoHash.getValue());
				}
			}

			return agendamentos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Agendamento> filtrarDia() {
		
		recuperaMap();
		
		try {
			List<Agendamento> agendamentos = new ArrayList<Agendamento>();
			return agendamentos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void salvar(Agendamento agendamento) {
		
		recuperaMap();
		
		HashMap<Integer, Agendamento> agendamentos = new HashMap<Integer, Agendamento>();
		Iterator<HashMap.Entry<Integer, Agendamento>> iterator = this.hashMb.getAgendamentos().entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Agendamento> agendamentoHash = iterator.next();
			if (agendamentoHash.getKey() != agendamento.getId_agendamento()) {
				agendamentos.put(agendamentoHash.getKey(), agendamentoHash.getValue());
			}
		}

		this.hashMb.setAgendamentos(agendamentos);
		this.hashMb.addAgendamento(agendamento.getId_agendamento(), agendamento);
	}

	public Agendamento lerPorId(Integer id) {
		
		recuperaMap();
		
		Agendamento agendamento = new Agendamento();
		Iterator<HashMap.Entry<Integer, Agendamento>> iterator = this.hashMb.getAgendamentos().entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Agendamento> agendamentoHash = iterator.next();
			if (agendamentoHash.getKey() == id) {
				agendamento = agendamentoHash.getValue();
			}
		}

		return agendamento;
	}

	public void excluir(Agendamento agendamento) {
		
		recuperaMap();
		
		HashMap<Integer, Agendamento> agendamentos = new HashMap<Integer, Agendamento>();

		Iterator<HashMap.Entry<Integer, Agendamento>> iterator = this.hashMb.getAgendamentos().entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Agendamento> agendamentoHash = iterator.next();
			if (agendamentoHash.getKey() != agendamento.getId_agendamento()) {
				agendamentos.put(agendamentoHash.getKey(), agendamentoHash.getValue());
			}
		}

		this.hashMb.setAgendamentos(agendamentos);
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
