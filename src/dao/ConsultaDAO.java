package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import mb.HashMB;
import model.Agendamento;
import model.Consulta;
import model.Prontuario;

public class ConsultaDAO {
	
	@Inject
	private HashMB hashMb;
	
	public List<Consulta> lerTodos() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		Iterator<HashMap.Entry<Integer, Consulta>> iterator = this.hashMb.getConsultas().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Consulta> consultasHash = iterator.next();
			consultas.add(consultasHash.getValue());
		}
		
		return consultas;
	}

	public List<Consulta> lerPorProntuario(Prontuario prontuario) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		Iterator<HashMap.Entry<Integer, Consulta>> iterator = this.hashMb.getConsultas().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Consulta> consultasHash = iterator.next();
			if (consultasHash.getValue().getProntuario().getCod_prontuario().equals(prontuario.getCod_prontuario())) {
				consultas.add(consultasHash.getValue());
			}
		}
		
		return consultas;
	}
	
	public void salvar(Consulta consulta) {
		HashMap<Integer, Consulta> consultas = new HashMap<Integer, Consulta>();
		Iterator<HashMap.Entry<Integer, Consulta>> iterator = this.hashMb.getConsultas().entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<Integer, Consulta> consultasHash = iterator.next();
			if (consultasHash.getKey() != consultasHash.getValue().getId_consulta()) {
				consultas.put(consultasHash.getKey(), consultasHash.getValue());
			}
		}
		
		this.hashMb.setConsultas(consultas);
		this.hashMb.addConsulta(consulta.getId_consulta(), consulta);
	}
}
