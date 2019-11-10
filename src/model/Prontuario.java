package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_prontuario")
@NamedQueries({ @NamedQuery(name = "Prontuario.findAll", query = "SELECT p FROM Prontuario p ") })
@SequenceGenerator(name = "PRONTUARIO_ID", sequenceName = "SEQ_PRONTUARIO", initialValue = 1, allocationSize = 1)
public class Prontuario {

	@Id
	@GeneratedValue(generator = "PRONTUARIO_ID", strategy = GenerationType.SEQUENCE)
	private Integer id_prontuario;

	@Column(name = "codigo_prontuario", unique = true)
	private String cod_prontuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_criacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultima_atualizacao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "num_prontuario")
	private Paciente paciente;

	@OneToMany(mappedBy = "prontuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Consulta> consultas;
	
	

	public Prontuario(Integer id_prontuario) {
		this.id_prontuario = id_prontuario;
	}
	
	public Prontuario() {
		
	}

	public Integer getId_prontuario() {
		return id_prontuario;
	}

	public void setId_prontuario(Integer id_prontuario) {
		this.id_prontuario = id_prontuario;
	}

	public String getCod_prontuario() {
		return cod_prontuario;
	}

	public void setCod_prontuario(String cod_prontuario) {
		this.cod_prontuario = cod_prontuario;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getUltima_atualizacao() {
		return ultima_atualizacao;
	}

	public void setUltima_atualizacao(Date ultima_atualizacao) {
		this.ultima_atualizacao = ultima_atualizacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_prontuario == null) ? 0 : id_prontuario.hashCode());
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
		Prontuario other = (Prontuario) obj;
		if (id_prontuario == null) {
			if (other.id_prontuario != null)
				return false;
		} else if (!id_prontuario.equals(other.id_prontuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prontuario [id_prontuario=" + id_prontuario + ", cod_prontuario=" + cod_prontuario + ", data_criacao="
				+ data_criacao + ", ultima_atualizacao=" + ultima_atualizacao + "]";
	}

	

}
