package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tab_medico")
public class Medico extends Pessoa {

	private String especialidade;

	@NotNull
	@Column(unique = true)
	private String crm;

	private String uf_crm;

	private String areaAtuacao;

	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Agendamento> agendamentos;

	public Medico() {
		super();
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getUf_crm() {
		return uf_crm;
	}

	public void setUf_crm(String uf_crm) {
		this.uf_crm = uf_crm;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
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

	@Override
	public String toString() {
		return "Medico [especialidade=" + especialidade + ", crm=" + crm + ", uf_crm=" + uf_crm + ", areaAtuacao="
				+ areaAtuacao + ", consultas=" + consultas + ", agendamentos=" + agendamentos + "]";
	}

	
}
