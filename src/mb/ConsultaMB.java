package mb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import dao.AgendamentoDAO;
import dao.AtestadoDAO;
import dao.ConsultaDAO;
import dao.PrescricaoDAO;
import model.Agendamento;
import model.Atestado;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Prescricao;
import model.Prontuario;

@ManagedBean(name = "consultaMB")
@SessionScoped
public class ConsultaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	// private String prontuario;
	// private String nome;
	// private String cpf;
	// private String dtNascimento;

	private Consulta consulta = new Consulta();
	private ConsultaMB consultaMB;
	private ConsultaDAO consultaDao = null;

	private Agendamento agendamento = null;
	private AgendamentoDAO agDao = null;

	private String nome;
	private String Codprontuario;
	private String cpf;
	private String dtNasc;

	private Medico medico = new Medico();
	private Paciente paciente = new Paciente();
	private Prontuario prontuario;

	private Atestado atestado = null;
	private AtestadoDAO ateDao = null;
	private Prescricao prescricao = null;
	private PrescricaoDAO presDao = null;

	private String motivoAtestado = null;
	private String detalhesMotivoAt = null;
	private String descricaoPresc = null;

	private String detalhe_relato, sis_dig_paciente, sis_cardio_paciente, sis_resp_paciente,
			sis_genitoUrinario_paciente;
	private String uso_medicamento, alergia, exame_geral, exame_cabecaPescoco, exame_abdomen, exame_apRespiratorio,
			exame_sistNervoso, exame_sistReprodutor;
	private String hipotese_detalhe, detalhes_diagnostico;

	private boolean skip;

	private List<Consulta> consultas;

	private List<Consulta> consultasFiltradas;

	private boolean exibir = false;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PostConstruct
	public void init() {
		if (consultaDao == null) {
			abrirConDAO();
		}
		consultas = consultaDao.lerTodos();
		
		fecharConDAO();
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Consulta> getConsultasFiltradas() {
		return consultasFiltradas;
	}

	public void setConsultasFiltradas(List<Consulta> consultasFiltradas) {
		this.consultasFiltradas = consultasFiltradas;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public void exibirPainel() {
		setExibir(true);
	}

	public boolean isExibir() {
		return exibir;
	}

	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}

	public boolean isSkip() {
		return skip;
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

	public String getHipotese_detalhe() {
		return hipotese_detalhe;
	}

	public void setHipotese_detalhe(String hipotese_detalhe) {
		this.hipotese_detalhe = hipotese_detalhe;
	}

	public String getDetalhes_diagnostico() {
		return detalhes_diagnostico;
	}

	public void setDetalhes_diagnostico(String detalhes_diagnostico) {
		this.detalhes_diagnostico = detalhes_diagnostico;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public ConsultaMB getConsultaMB() {
		return consultaMB;
	}

	public void setConsultaMB(ConsultaMB consultaMB) {
		this.consultaMB = consultaMB;
	}

	public ConsultaDAO getConsultaDao() {
		return consultaDao;
	}

	public void setConsultaDao(ConsultaDAO consultaDao) {
		this.consultaDao = consultaDao;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodprontuario() {
		return Codprontuario;
	}

	public void setCodprontuario(String codprontuario) {
		Codprontuario = codprontuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Atestado getAtestado() {
		return atestado;
	}

	public void setAtestado(Atestado atestado) {
		this.atestado = atestado;
	}

	public AtestadoDAO getAteDao() {
		return ateDao;
	}

	public void setAteDao(AtestadoDAO ateDao) {
		this.ateDao = ateDao;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	public PrescricaoDAO getPresDao() {
		return presDao;
	}

	public void setPresDao(PrescricaoDAO presDao) {
		this.presDao = presDao;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public AgendamentoDAO getAgDao() {
		return agDao;
	}

	public void setAgDao(AgendamentoDAO agDao) {
		this.agDao = agDao;
	};

	public String getMotivoAtestado() {
		return motivoAtestado;
	}

	public void setMotivoAtestado(String motivoAtestado) {
		this.motivoAtestado = motivoAtestado;
	}

	public String getDetalhesMotivoAt() {
		return detalhesMotivoAt;
	}

	public void setDetalhesMotivoAt(String detalhesMotivoAt) {
		this.detalhesMotivoAt = detalhesMotivoAt;
	}

	public String getDescricaoPresc() {
		return descricaoPresc;
	}

	public void setDescricaoPresc(String descricaoPresc) {
		this.descricaoPresc = descricaoPresc;
	}

	public String realizarConsulta(Integer codigo) {

		if (agDao == null) {
			abrirAgDAO();
		}
		agendamento = this.agDao.lerPorId(codigo);

		fecharAgDAO();

		nome = agendamento.getPaciente().getNome();
		cpf = agendamento.getPaciente().getCpf();
		Codprontuario = agendamento.getPaciente().getNum_prontuario().getCod_prontuario();
		dtNasc = agendamento.getPaciente().getDt_nascimento();

		return "/restrito/consulta/realizarConsulta.jsf?faces-redirect=true";
	}

	public void iniciarAtendimento() {

		try {

			Integer codigo = agendamento.getId_agendamento();
			this.consulta = new Consulta();
			// Registra o timestamp Inicial da consulta
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			this.consulta.setInicio_consulta(calendar.getTime());
			this.consulta.setPaciente(agendamento.getPaciente());
			this.consulta.setProntuario(agendamento.getPaciente().getNum_prontuario());
			this.consulta.setMedico(agendamento.getMedico());
			this.consulta.setTipo_consulta(agendamento.getTipo());

			mudaStatusAgendamento(codigo);
			exibir = true;

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Atendimento em andamento!"));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "Problema ao iniciar o atendimento!"));
		}

	}

	public String finalizarAtendimento() {

		try {

			fixConteudo();

			atestado = new Atestado();
			prescricao = new Prescricao();

			// Registra o timestamp final da consulta
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			// Passando os valores do atestado

			atestado.setConsulta(this.consulta);
			atestado.setData_ocorrido(calendar.getTime());
			atestado.setMotivo(motivoAtestado);
			atestado.setDetalhes_motivo(detalhesMotivoAt);
			// this.ateDao.salvar(atestado);

			// Passando os valores da Prescricao

			prescricao.setConsulta(this.consulta);
			prescricao.setData_criacao(calendar.getTime());
			prescricao.setDescricao(descricaoPresc);
			// this.presDao.salvar(prescricao);

			// Horario final da consulta

			if (consultaDao == null) {
				abrirConDAO();
			}
			this.consulta.setAlergia(alergia);
			this.consulta.setDetalhe_relato(detalhe_relato);
			this.consulta.setDetalhes_diagnostico(detalhes_diagnostico);
			this.consulta.setExame_abdomen(exame_abdomen);
			this.consulta.setExame_apRespiratorio(exame_apRespiratorio);
			this.consulta.setExame_cabecaPescoco(exame_cabecaPescoco);
			this.consulta.setExame_geral(exame_geral);
			this.consulta.setExame_sistNervoso(exame_sistNervoso);
			this.consulta.setExame_sistReprodutor(exame_sistReprodutor);
			this.consulta.setHipotese_detalhe(hipotese_detalhe);
			this.consulta.setSis_cardio_paciente(sis_cardio_paciente);
			this.consulta.setSis_dig_paciente(sis_dig_paciente);
			this.consulta.setSis_genitoUrinario_paciente(sis_genitoUrinario_paciente);
			this.consulta.setSis_resp_paciente(sis_resp_paciente);
			this.consulta.setAtestado(atestado);
			this.consulta.setPrescricoes(prescricao);
			this.consulta.setFinal_consulta(calendar.getTime());
			// Registra no banco
			this.consultaDao.salvar(this.consulta);

			fecharConDAO();

			if (agDao == null) {
				abrirAgDAO();
			}
			agendamento.setStatus_agendamento("CONCLUIDO");
			agDao.salvar(agendamento);

			fecharAgDAO();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Atendimento finalizado com sucesso!"));

			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			return "/restrito/atendimento/buscarAgendamento.jsf?faces-redirect=true";

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "Problemas ao finalizar o atendimento!"));
		}
		return null;
	}

	public void fixConteudo() {

		motivoAtestado.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		descricaoPresc.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		detalhe_relato.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		detalhes_diagnostico.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		alergia.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		detalhesMotivoAt.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_abdomen.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_apRespiratorio.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_cabecaPescoco.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_geral.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_sistNervoso.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		exame_sistReprodutor.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		hipotese_detalhe.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		sis_cardio_paciente.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		sis_dig_paciente.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		sis_genitoUrinario_paciente.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		sis_resp_paciente.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

	};

	public void mudaStatusAgendamento(Integer codigo) {

		if (agDao == null) {
			abrirAgDAO();
		}
		System.out.println(codigo);
		agendamento = agDao.lerPorId(codigo);
		agendamento.setId_agendamento(codigo);
		agendamento.setStatus_agendamento("EM ATENDIMENTO");
		agDao.salvar(agendamento);

		fecharAgDAO();

	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public void abrirConDAO() {

		this.consultaDao = new ConsultaDAO();

	};

	public void fecharConDAO() {

		if (consultaDao.getEntityManager().isOpen()) {
			consultaDao.fecharConexao();
			consultaDao.getEntityManager().close();
			consultaDao = null;
		}
	};

	public void abrirAgDAO() {

		this.agDao = new AgendamentoDAO();

	};

	public void fecharAgDAO() {

		if (agDao.getEntityManager().isOpen()) {
			agDao.fecharConexao();
			agDao.getEntityManager().close();
		}
		agDao = null;

	}

	public void abrirAteDAO() {

		this.ateDao = new AtestadoDAO();

	};

	public void fecharAteDAO() {

		if (ateDao.getEntityManager().isOpen()) {
			ateDao.fecharConexao();
			ateDao.getEntityManager().close();
		}
		ateDao = null;

	}

	public void abrirPresDAO() {

		this.presDao = new PrescricaoDAO();

	};

	public void fecharPresDAO() {

		if (presDao.getEntityManager().isOpen()) {
			presDao.fecharConexao();
			presDao.getEntityManager().close();
		}
		presDao = null;

	}

	public String getSis_dig_paciente() {
		return sis_dig_paciente;
	}

	public void setSis_dig_paciente(String sis_dig_paciente) {
		this.sis_dig_paciente = sis_dig_paciente;
	}

	public String getDetalhe_relato() {
		return detalhe_relato;
	}

	public void setDetalhe_relato(String detalhe_relato) {
		this.detalhe_relato = detalhe_relato;
	}

}
