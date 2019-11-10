package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_paciente")
public class Paciente extends Pessoa {

	@OneToOne(cascade = CascadeType.ALL)
	private Prontuario num_prontuario;

	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Agendamento> agendamentos;
	
	

	public Paciente() {
		super();
	}


	public Prontuario getNum_prontuario() {
		return num_prontuario;
	}


	public void setNum_prontuario(Prontuario num_prontuario) {
		this.num_prontuario = num_prontuario;
	}


	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}


		

	

}
