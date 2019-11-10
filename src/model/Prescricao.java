package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_prescricao")
@SequenceGenerator(name = "PRESCRICAO_ID", sequenceName = "SEQ_PRESCRICAO", initialValue = 1, allocationSize = 1)
public class Prescricao {

	@Id
	@GeneratedValue(generator = "PRESCRICAO_ID", strategy = GenerationType.SEQUENCE)
	private Integer id_prescricao;

	private String descricao;

	private String tipo_prescricao;

	private Date data_criacao;

	@OneToOne(mappedBy = "prescricao")
	private Consulta consulta;

	public Integer getId_prescricao() {
		return id_prescricao;
	}

	public void setId_prescricao(Integer id_prescricao) {
		this.id_prescricao = id_prescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_prescricao() {
		return tipo_prescricao;
	}

	public void setTipo_prescricao(String tipo_prescricao) {
		this.tipo_prescricao = tipo_prescricao;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_prescricao == null) ? 0 : id_prescricao.hashCode());
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
		Prescricao other = (Prescricao) obj;
		if (id_prescricao == null) {
			if (other.id_prescricao != null)
				return false;
		} else if (!id_prescricao.equals(other.id_prescricao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prescricao [id_prescricao=" + id_prescricao + ", descricao=" + descricao + ", tipo_prescricao="
				+ tipo_prescricao + ", data_criacao=" + data_criacao + ", consulta=" + consulta + "]";
	}

}
