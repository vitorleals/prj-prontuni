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
@Table(name = "tab_atestados")
@SequenceGenerator(name = "ATESTADO_ID", sequenceName = "SEQ_ATESTADO", initialValue = 1, allocationSize = 1)
public class Atestado {

	@Id
	@GeneratedValue(generator = "ATESTADO_ID", strategy = GenerationType.SEQUENCE)
	private Integer id_atestado;

	private String motivo;

	private String detalhes_motivo;

	private Date data_ocorrido;

	@OneToOne(mappedBy = "atestado")
	private Consulta consulta;

	public Integer getId_atestado() {
		return id_atestado;
	}

	public void setId_atestado(Integer id_atestado) {
		this.id_atestado = id_atestado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDetalhes_motivo() {
		return detalhes_motivo;
	}

	public void setDetalhes_motivo(String detalhes_motivo) {
		this.detalhes_motivo = detalhes_motivo;
	}

	public Date getData_ocorrido() {
		return data_ocorrido;
	}

	public void setData_ocorrido(Date data_ocorrido) {
		this.data_ocorrido = data_ocorrido;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_atestado == null) ? 0 : id_atestado.hashCode());
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
		Atestado other = (Atestado) obj;
		if (id_atestado == null) {
			if (other.id_atestado != null)
				return false;
		} else if (!id_atestado.equals(other.id_atestado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atestado [id_atestado=" + id_atestado + ", motivo=" + motivo + ", detalhes_motivo=" + detalhes_motivo
				+ ", data_ocorrido=" + data_ocorrido + ", consulta=" + consulta + "]";
	}


}
