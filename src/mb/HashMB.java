package mb;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Agendamento;
import model.Consulta;
import model.Enfermeiro;
import model.Medico;
import model.Paciente;
import model.Unidade;

@ManagedBean(name = "hashMB")
@SessionScoped
public class HashMB {
	
	private HashMap<Integer, Paciente> pacientes = new HashMap<Integer, Paciente>();
	private HashMap<Integer, Medico> medicos = new HashMap<Integer, Medico>();	
	private HashMap<Integer, Enfermeiro> enfermeiros = new HashMap<Integer, Enfermeiro>();	
	private HashMap<Integer, Agendamento> agendamentos = new HashMap<Integer, Agendamento>();
	private HashMap<Integer, Unidade> unidades = new HashMap<Integer, Unidade>();
	private HashMap<Integer, Consulta> consultas = new HashMap<Integer, Consulta>();
	
	public HashMap<Integer, Consulta> getConsultas() {
		return consultas;
	}

	public HashMap<Integer, Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public void setEnfermeiros(HashMap<Integer, Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

	public void setConsultas(HashMap<Integer, Consulta> consultas) {
		this.consultas = consultas;
	}

	public HashMap<Integer, Paciente> getPacientes() {
		return this.pacientes;
	}
	
	public HashMap<Integer, Medico> getMedicos() {
		return this.medicos;
	}
	
	public HashMap<Integer, Agendamento> getAgendamentos() {
		return this.agendamentos;
	}
	
	public HashMap<Integer, Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(HashMap<Integer, Unidade> unidades) {
		this.unidades = unidades;
	}

	public void setPacientes(HashMap<Integer, Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void setMedicos(HashMap<Integer, Medico> medicos) {
		this.medicos = medicos;
	}

	public void setAgendamentos(HashMap<Integer, Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public void addPaciente(Integer key, Paciente paciente) {
		this.pacientes.put(key, paciente);
	}
	
	public void addMedico(Integer key, Medico medico) {
		this.medicos.put(key, medico);
	}
	
	public void addEnfermeiro(Integer key, Enfermeiro enfermeiro) {
		this.enfermeiros.put(key, enfermeiro);
	}
	
	public void addAgendamento(Integer key, Agendamento agendamento) {
		this.agendamentos.put(key, agendamento);
	}
	
	public void addUnidade(Integer key, Unidade unidade) {
		this.unidades.put(key, unidade);
	}	
	
	public void addConsulta(Integer key, Consulta consulta) {
		this.consultas.put(key, consulta);
	}
}
