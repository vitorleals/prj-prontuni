package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_agendamento")
@SequenceGenerator(name = "AGENDAMENTO_ID", sequenceName = "SEQ_AGENDAMENTO", initialValue = 1, allocationSize = 1)
public class Agendamento {

	@Id
	@GeneratedValue(generator = "AGENDAMENTO_ID", strategy = GenerationType.SEQUENCE)
	private Integer id_agendamento;

	private String tipo;

	private String observacao;

	@Column(unique=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_inicio;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_final;

	private String status_agendamento;

	@ManyToOne
	@JoinColumn(name = "agendamentos_pac")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "agendamentos_med")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "agendamentos_unidade")
	private Unidade unidade;

	public Agendamento() {
		super();
	}

	public Integer getId_agendamento() {
		return id_agendamento;
	}

	public void setId_agendamento(Integer id_agendamento) {
		this.id_agendamento = id_agendamento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getStatus_agendamento() {
		return status_agendamento;
	}

	public void setStatus_agendamento(String status_agendamento) {
		this.status_agendamento = status_agendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_agendamento == null) ? 0 : id_agendamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id_agendamento == null) {
			if (other.id_agendamento != null)
				return false;
		} else if (!id_agendamento.equals(other.id_agendamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [id_agendamento=" + id_agendamento + ", tipo=" + tipo + ", observacao=" + observacao
				+ ", data_inicio=" + data_inicio + ", data_final=" + data_final + ", status_agendamento="
				+ status_agendamento + "]";
	}




}
