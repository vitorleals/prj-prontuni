package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_consultas")
@SequenceGenerator(name = "CONSULTA_ID", sequenceName = "SEQ_CONSULTA", initialValue = 1, allocationSize = 1)
public class Consulta {

	@Id
	@GeneratedValue(generator = "CONSULTA_ID", strategy = GenerationType.SEQUENCE)
	private Integer id_consulta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio_consulta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date final_consulta;

	private String tipo_consulta;

	@ManyToOne
	@JoinColumn(name = "consultas_pac")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "consultas_pront")
	private Prontuario prontuario;

	@ManyToOne
	@JoinColumn(name = "consultas_med")
	private Medico medico;

//	Atributos relacionado ao atendimento do paciente
	private String relato_paciente;
	private String detalhe_relato;
	private String temperatura;
	private String pressao_arterial;
	private Float peso;
	private Float altura;
	private String cabeca_paciente;
	private String olho_paciente;
	private String nariz_paciente;
	private String pele_paciente;
	private String garganta_paciente;
	private String ouvido_paciente;
	private String sis_dig_paciente;
	private String sis_cardio_paciente;
	private String sis_resp_paciente;
	private String sis_genitoUrinario_paciente;
	private String uso_medicamento;
	private String doencaMental;
	private String alergia;

	private String exame_geral;
	private String exame_cabecaPescoco;
	private String exame_abdomen;
	private String exame_apRespiratorio;
	private String exame_sistNervoso;
	private String exame_sistReprodutor;

	private String hipotese_diagnostico;
	private String hipotese_detalhe;

	private String diagnostico;
	private String detalhes_diagnostico;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRESCRICAO_ID")
	private Prescricao prescricao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ATESTADO_ID")
	private Atestado atestado;

	public Consulta() {
	}

	public Consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}

	/*
	 * Getters and Setters
	 * 
	 */

	public Integer getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Date getInicio_consulta() {
		return inicio_consulta;
	}

	public void setInicio_consulta(Date inicio_consulta) {
		this.inicio_consulta = inicio_consulta;
	}

	public Date getFinal_consulta() {
		return final_consulta;
	}

	public void setFinal_consulta(Date final_consulta) {
		this.final_consulta = final_consulta;
	}

	public String getTipo_consulta() {
		return tipo_consulta;
	}

	public void setTipo_consulta(String tipo_consulta) {
		this.tipo_consulta = tipo_consulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getRelato_paciente() {
		return relato_paciente;
	}

	public void setRelato_paciente(String relato_paciente) {
		this.relato_paciente = relato_paciente;
	}

	public String getDetalhe_relato() {
		return detalhe_relato;
	}

	public void setDetalhe_relato(String detalhe_relato) {
		this.detalhe_relato = detalhe_relato;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPressao_arterial() {
		return pressao_arterial;
	}

	public void setPressao_arterial(String pressao_arterial) {
		this.pressao_arterial = pressao_arterial;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public String getCabeca_paciente() {
		return cabeca_paciente;
	}

	public void setCabeca_paciente(String cabeca_paciente) {
		this.cabeca_paciente = cabeca_paciente;
	}

	public String getOlho_paciente() {
		return olho_paciente;
	}

	public void setOlho_paciente(String olho_paciente) {
		this.olho_paciente = olho_paciente;
	}

	public String getNariz_paciente() {
		return nariz_paciente;
	}

	public void setNariz_paciente(String nariz_paciente) {
		this.nariz_paciente = nariz_paciente;
	}

	public String getPele_paciente() {
		return pele_paciente;
	}

	public void setPele_paciente(String pele_paciente) {
		this.pele_paciente = pele_paciente;
	}

	public String getGarganta_paciente() {
		return garganta_paciente;
	}

	public void setGarganta_paciente(String garganta_paciente) {
		this.garganta_paciente = garganta_paciente;
	}

	public String getOuvido_paciente() {
		return ouvido_paciente;
	}

	public void setOuvido_paciente(String ouvido_paciente) {
		this.ouvido_paciente = ouvido_paciente;
	}

	public String getSis_dig_paciente() {
		return sis_dig_paciente;
	}

	public void setSis_dig_paciente(String sis_dig_paciente) {
		this.sis_dig_paciente = sis_dig_paciente;
	}

	public String getSis_cardio_paciente() {
		return sis_cardio_paciente;
	}

	public void setSis_cardio_paciente(String sis_cardio_paciente) {
		this.sis_cardio_paciente = sis_cardio_paciente;
	}

	public String getSis_resp_paciente() {
		return sis_resp_paciente;
	}

	public void setSis_resp_paciente(String sis_resp_paciente) {
		this.sis_resp_paciente = sis_resp_paciente;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getSis_genitoUrinario_paciente() {
		return sis_genitoUrinario_paciente;
	}

	public void setSis_genitoUrinario_paciente(String sis_genitoUrinario_paciente) {
		this.sis_genitoUrinario_paciente = sis_genitoUrinario_paciente;
	}

	public String getUso_medicamento() {
		return uso_medicamento;
	}

	public void setUso_medicamento(String uso_medicamento) {
		this.uso_medicamento = uso_medicamento;
	}

	public String getDoencaMental() {
		return doencaMental;
	}

	public void setDoencaMental(String doencaMental) {
		this.doencaMental = doencaMental;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getExame_geral() {
		return exame_geral;
	}

	public void setExame_geral(String exame_geral) {
		this.exame_geral = exame_geral;
	}

	public String getExame_cabecaPescoco() {
		return exame_cabecaPescoco;
	}

	public void setExame_cabecaPescoco(String exame_cabecaPescoco) {
		this.exame_cabecaPescoco = exame_cabecaPescoco;
	}

	public String getExame_abdomen() {
		return exame_abdomen;
	}

	public void setExame_abdomen(String exame_abdomen) {
		this.exame_abdomen = exame_abdomen;
	}

	public String getExame_apRespiratorio() {
		return exame_apRespiratorio;
	}

	public void setExame_apRespiratorio(String exame_apRespiratorio) {
		this.exame_apRespiratorio = exame_apRespiratorio;
	}

	public String getExame_sistNervoso() {
		return exame_sistNervoso;
	}

	public void setExame_sistNervoso(String exame_sistNervoso) {
		this.exame_sistNervoso = exame_sistNervoso;
	}

	public String getExame_sistReprodutor() {
		return exame_sistReprodutor;
	}

	public void setExame_sistReprodutor(String exame_sistReprodutor) {
		this.exame_sistReprodutor = exame_sistReprodutor;
	}

	public String getDetalhes_diagnostico() {
		return detalhes_diagnostico;
	}

	public void setDetalhes_diagnostico(String detalhes_diagnostico) {
		this.detalhes_diagnostico = detalhes_diagnostico;
	}

	public Prescricao getPrescricoes() {
		return prescricao;
	}

	public void setPrescricoes(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	public Atestado getAtestado() {
		return atestado;
	}

	public void setAtestado(Atestado atestado) {
		this.atestado = atestado;
	}

	public String getHipotese_diagnostico() {
		return hipotese_diagnostico;
	}

	public void setHipotese_diagnostico(String hipotese_diagnostico) {
		this.hipotese_diagnostico = hipotese_diagnostico;
	}

	public String getHipotese_detalhe() {
		return hipotese_detalhe;
	}

	public void setHipotese_detalhe(String hipotese_detalhe) {
		this.hipotese_detalhe = hipotese_detalhe;
	}

	/*
	 * HashCode and Equals
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_consulta == null) ? 0 : id_consulta.hashCode());
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
		Consulta other = (Consulta) obj;
		if (id_consulta == null) {
			if (other.id_consulta != null)
				return false;
		} else if (!id_consulta.equals(other.id_consulta))
			return false;
		return true;
	}

	/*
	 * Metodo ToString
	 * 
	 */
	@Override
	public String toString() {
		return "Consulta [id_consulta=" + id_consulta + ", inicio_consulta=" + inicio_consulta + ", final_consulta="
				+ final_consulta + ", tipo_consulta=" + tipo_consulta + ", paciente=" + paciente + ", prontuario="
				+ prontuario + ", medico=" + medico + ", relato_paciente=" + relato_paciente + ", detalhe_relato="
				+ detalhe_relato + ", temperatura=" + temperatura + ", pressao_arterial=" + pressao_arterial + ", peso="
				+ peso + ", altura=" + altura + ", cabeca_paciente=" + cabeca_paciente + ", olho_paciente="
				+ olho_paciente + ", nariz_paciente=" + nariz_paciente + ", pele_paciente=" + pele_paciente
				+ ", garganta_paciente=" + garganta_paciente + ", ouvido_paciente=" + ouvido_paciente
				+ ", sis_dig_paciente=" + sis_dig_paciente + ", sis_cardio_paciente=" + sis_cardio_paciente
				+ ", sis_resp_paciente=" + sis_resp_paciente + ", sis_genitoUrinario_paciente="
				+ sis_genitoUrinario_paciente + ", uso_medicamento=" + uso_medicamento + ", doencaMental="
				+ doencaMental + ", alergia=" + alergia + ", exame_geral=" + exame_geral + ", exame_cabecaPescoco="
				+ exame_cabecaPescoco + ", exame_abdomen=" + exame_abdomen + ", exame_apRespiratorio="
				+ exame_apRespiratorio + ", exame_sistNervoso=" + exame_sistNervoso + ", exame_sistReprodutor="
				+ exame_sistReprodutor + ", hipotese_diagnostico=" + hipotese_diagnostico + ", hipotese_detalhe="
				+ hipotese_detalhe + ", diagnostico=" + diagnostico + ", detalhes_diagnostico=" + detalhes_diagnostico
				+ "]";
	}

}
