package mb;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.event.TimeSelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import dao.AgendamentoDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.UnidadeDAO;
import model.Agendamento;
import model.Medico;
import model.Paciente;
import model.Unidade;

@ManagedBean(name = "agendamentoMB")
@ViewScoped
public class AgendamentoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ScheduleModel agendamentos;
	private ScheduleEvent event = new DefaultScheduleEvent();

	@Inject
	private AgendamentoMB agendamentoMB;

	@Inject
	private NavegacaoMB navMB;

	private List<Agendamento> listaAgenda;
	private List<Agendamento> listaAgenda2;
	private Agendamento agendamento = new Agendamento();
	private Agendamento agSelecionado;
	private AgendamentoDAO agendamentoDAO = null;
	private List<Agendamento> listAtendimento;

	private Paciente paciente;
	private PacienteDAO pacienteDAO = null;
	private List<Paciente> pacientes = null;

	private Medico medico = new Medico();
	private MedicoDAO medDao = null;
	private List<Medico> medicos = null;

	private Unidade unidade;
	private UnidadeDAO uniDao = null;
	private List<Unidade> unidades = null;

	private Date data = new Date();
	private Date dataConsulta;
	private Date horaInicioConsulta;
	private Date horaFinalConsulta;
	private String tipoConsulta;

	private Date dataAgendamento;
	private Date horaAgendamento;

	private Date dataIniForm;

	@PostConstruct
	public void init() {

		try {

			agendamentos = new DefaultScheduleModel();

			if (agendamentoDAO == null) {

				abrirAgDAO();
			}

			listaAgenda = agendamentoDAO.lerTodos();
			listaAgenda2 = agendamentoDAO.filtrarDia();

			fecharAgDAO();

			// listAtendimento = agendamentoDAO.lerPorStatus(); A FAZER
			// ##########################################
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Falha ao recuperar os agendamentos"));

		}

		for (Agendamento agendamento : listaAgenda) {
			DefaultScheduleEvent evt = new DefaultScheduleEvent();
			evt.setData(agendamento.getId_agendamento());
			evt.setStartDate(agendamento.getData_inicio());
			evt.setEndDate(agendamento.getData_final());
			evt.setEditable(false);
			evt.setTitle(agendamento.getTipo());
			evt.setDescription(agendamento.getPaciente().getNome());
			evt.setDescription(agendamento.getMedico().getNome());
			evt.setDescription(agendamento.getObservacao());
			evt.setDescription(agendamento.getUnidade().getNome_unidade());

			agendamentos.addEvent(evt);
		}
	}
	/*
	 * 
	 * METODOS GETTERS AND SETTERS
	 * 
	 */

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public AgendamentoMB getAgendamentoMB() {
		return agendamentoMB;
	}

	public List<Agendamento> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agendamento> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public void setAgendamentoMB(AgendamentoMB agendamentoMB) {
		this.agendamentoMB = agendamentoMB;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public AgendamentoDAO getAgendamentoDAO() {
		return agendamentoDAO;
	}

	public void setAgendamentoDAO(AgendamentoDAO agendamentoDAO) {
		this.agendamentoDAO = agendamentoDAO;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public List<Paciente> getPacientes() {
		if (this.pacientes == null) {
			if (pacienteDAO == null) {
				abrirPacDAO();
			}
			this.pacientes = pacienteDAO.lerTodos();
			fecharPacDAO();

		}

		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Medico> getMedicos() {

		if (this.medicos == null) {
			if (medDao == null) {
				abrirMedDAO();
			}
			this.medicos = medDao.lerTodos();
			fecharMedDAO();

		}
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Unidade> getUnidades() {

		if (this.unidades == null) {
			if (uniDao == null) {
				abrirUniDAO();
			}
			this.unidades = uniDao.lerTodos();
			fecharUniDAO();

		}
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MedicoDAO getMedDao() {
		return medDao;
	}

	public void setMedDao(MedicoDAO medDao) {
		this.medDao = medDao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public ScheduleModel getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(ScheduleModel agendamentos) {
		this.agendamentos = agendamentos;
	}

	@NotBlank
	public String getNomePaciente() {
		return agendamento.getPaciente() == null ? null : agendamento.getPaciente().getNome();

	}

	public void setNomePaciente(String nome) {

	}

	@NotBlank
	public String getNomeMedico() {
		return agendamento.getMedico() == null ? null : agendamento.getMedico().getNome();

	}

	public void setNomeMedico(String nome) {

	}

	@NotBlank
	public String getNomeUnidade() {
		return agendamento.getUnidade() == null ? null : agendamento.getUnidade().getNome_unidade();

	}

	public void setNomeUnidade(String nome) {

	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UnidadeDAO getUniDao() {
		return uniDao;
	}

	public void setUniDao(UnidadeDAO uniDao) {
		this.uniDao = uniDao;
	}

	/*
	 * 
	 * OUTROS METODOS
	 * 
	 */

	public void timeSelectListener(TimeSelectEvent timeSelectEvent) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Time select fired",
				"Selected time: " + getFormattedTime(timeSelectEvent.getTime(), "HH:mm"));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void novoRegistro(SelectEvent selectEvent) {

		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
		agendamento = new Agendamento();
		agendamento.setData_inicio(event.getStartDate());
		agendamento.setData_final(event.getEndDate());

	}

	public void registroSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();

		for (Agendamento ag : listaAgenda) {
			if (ag.getId_agendamento() == (Integer) event.getData()) {
				agendamento = ag;
				break;
			}
		}
	}

	public void salvarRegistro() throws SQLException{

		if (agendamento.getId_agendamento() == null) {

			// FORMATANDO TIPO DE CONSULTA (UPPERCASE)
			agendamento.setTipo(agendamento.getTipo().toUpperCase());

			// INSERINDO TEMPO DE CONSULTA DE ACORDO COM O TIPO
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(agendamento.getData_inicio());
			calendar.add(Calendar.MINUTE, 30);
			agendamento.setData_final(calendar.getTime());

			if (agendamento.getData_inicio().getTime() < agendamento.getData_final().getTime()) {
				try {
					String status = "AGUARDANDO ATENDIMENTO";
					agendamento.setStatus_agendamento(status);

					if (agendamentoDAO == null) {

						abrirAgDAO();
					}

					agendamentoDAO.salvar(agendamento);

					agendamentos.addEvent(event);
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Sucesso", "Agendamento realizado com sucesso!"));

					fecharAgDAO();


				} catch (Exception e) {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Ops!", "Já existe outro agendamento neste mesmo horário."));
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Falha", "A hora inicial da consulta não pode ser maior que a hora final."));
				fecharAgDAO();
			}
		} else {
			try {
				if (agendamentoDAO == null) {

					abrirAgDAO();
				}

				agendamentoDAO.salvar(this.agendamento);

				agendamentos.updateEvent(event);

				fecharAgDAO();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Falha ao atualizar agendamento."));

				fecharAgDAO();
			}

		}

		event = new DefaultScheduleEvent();
	}

	public String salvaAgendamento() {

		try {

			recebeData();
			agendamento.setTipo(agendamento.getTipo().toUpperCase());
			String status = "AGUARDANDO ATENDIMENTO";
			agendamento.setStatus_agendamento(status);

			if (this.agendamentoDAO == null) {
				abrirAgDAO();
			}

			this.agendamentoDAO.salvar(this.agendamento);

			fecharAgDAO();

			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().redirect("buscarAgendamento.jsf?faces-redirect=true");
			context.addMessage(null, new FacesMessage("Agendamento realizado com sucesso!", "Sucesso!"));

			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			return "/restrito/atendimento/buscarAgendamento.jsf?faces-redirect=true";

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Problemas ao agendar consulta!", "Problemas ao agendar consulta!"));

		}
		return null;
	}

	public String acaoExcluir(Integer codigo) {

		try {

			if (agendamentoDAO == null) {

				abrirAgDAO();
			}

			agendamento = this.agendamentoDAO.lerPorId(codigo);
			this.agendamentoDAO.excluir(agendamento);

			listaAgenda = agendamentoDAO.lerTodos();

			fecharAgDAO();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Agendamento eliminado com sucesso!", "Sucesso!"));

		} catch (Exception e) {
			System.err.println("SAIU NA EXCEPTION");
		}

		return null;
	}

	public String acaoListarAgendamentos() {

		return "/restrito/agendamento/buscarAgendamento.jsf?faces-redirect=true";
	}

	public void recebeData() throws ParseException {

		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

		String data = sdfData.format(dataAgendamento);
		String hora = sdfHora.format(horaAgendamento);

		String dataHora = data + " " + hora;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataFormatada = new Date(format.parse(dataHora).getTime());

		this.agendamento.setData_inicio(dataFormatada);

		// INSERINDO TEMPO DE CONSULTA DE ACORDO COM O TIPO
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFormatada);
		calendar.add(Calendar.MINUTE, 30);
		this.agendamento.setData_final(calendar.getTime());

	}

	public void filtrarAgenda(Integer codigo) {

		if (uniDao == null) {
			abrirUniDAO();
		}
		this.unidade = this.uniDao.lerPorId(codigo);
		Integer codUnidade = this.unidade.getId_unidade();

		System.out.println(codUnidade);

		fecharUniDAO();
		if (agendamentoDAO == null) {
			abrirAgDAO();
		}
		agendamentos = new DefaultScheduleModel();

		listaAgenda = agendamentoDAO.filtrar(codUnidade);

		System.out.println(listaAgenda);

		fecharAgDAO();

		for (Agendamento agendamento : listaAgenda) {
			DefaultScheduleEvent evt = new DefaultScheduleEvent();
			evt.setData(agendamento.getId_agendamento());
			evt.setStartDate(agendamento.getData_inicio());
			evt.setEndDate(agendamento.getData_final());
			evt.setEditable(false);
			evt.setTitle(agendamento.getTipo());
			evt.setDescription(agendamento.getPaciente().getNome());
			evt.setDescription(agendamento.getMedico().getNome());
			evt.setDescription(agendamento.getObservacao());
			evt.setDescription(agendamento.getUnidade().getNome_unidade());

			agendamentos.addEvent(evt);
		}
	}

	public String excluirRegistro(Integer codigo) {

		if (agendamentoDAO == null) {

			abrirAgDAO();
		}

		this.agendamento = this.agendamentoDAO.lerPorId(codigo);
		this.agendamentoDAO.excluir(agendamento);
		fecharAgDAO();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Agendamento eliminado com sucesso!"));
		return navMB.paginaCalendario();
	}

	public void pacienteSelecionado(SelectEvent event) {
		Paciente paciente = (Paciente) event.getObject();
		agendamento.setPaciente(paciente);
	}

	public void medicoSelecionado(SelectEvent event) {
		Medico medico = (Medico) event.getObject();
		agendamento.setMedico(medico);
	}

	public void unidadeSelecionada(SelectEvent event) {
		Unidade unidade = (Unidade) event.getObject();
		agendamento.setUnidade(unidade);
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Date getHoraInicioConsulta() {
		return horaInicioConsulta;
	}

	public void setHoraInicioConsulta(Date horaInicioConsulta) {
		this.horaInicioConsulta = horaInicioConsulta;
	}

	public Date getHoraFinalConsulta() {
		return horaFinalConsulta;
	}

	public void setHoraFinalConsulta(Date horaFinalConsulta) {
		this.horaFinalConsulta = horaFinalConsulta;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public Date getDataIniForm() {
		return dataIniForm;
	}

	public void setDataIniForm(Date dataIniForm) {
		this.dataIniForm = dataIniForm;
	}

	private String getFormattedTime(Date time, String format) {
		if (time == null) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		return simpleDateFormat.format(time);
	}

	public String iniciarAtendimento(Integer codigo) {
		this.agendamento = this.agendamentoDAO.lerPorId(codigo);

		return navMB.paginaRealizarConsulta();
	}

	public NavegacaoMB getNavMB() {
		return navMB;
	}

	public void setNavMB(NavegacaoMB navMB) {
		this.navMB = navMB;
	}

	public List<Agendamento> getListAtendimento() {
		return listAtendimento;
	}

	public void setListAtendimento(List<Agendamento> listAtendimento) {
		this.listAtendimento = listAtendimento;
	}

	public Agendamento getAgSelecionado() {
		return agSelecionado;
	}

	public void setAgSelecionado(Agendamento agSelecionado) {
		this.agSelecionado = agSelecionado;
	}

	public List<Agendamento> getListaAgenda2() {
		return listaAgenda2;
	}

	public void setListaAgenda2(List<Agendamento> listaAgenda2) {
		this.listaAgenda2 = listaAgenda2;
	}

	public void abrirAgDAO() {

		this.agendamentoDAO = new AgendamentoDAO();

	};

	public void fecharAgDAO() {
		if (agendamentoDAO.getEntityManager().isOpen()) {
			agendamentoDAO.fecharConexao();
			agendamentoDAO.getEntityManager().close();
		}
		agendamentoDAO = null;

	};

	public void abrirPacDAO() {

		this.pacienteDAO = new PacienteDAO();

	};

	public void fecharPacDAO() {

		pacienteDAO.fecharConexao();
		pacienteDAO.getEntityManager().close();
		pacienteDAO = null;

	};

	public void abrirMedDAO() {

		this.medDao = new MedicoDAO();

	};

	public void fecharMedDAO() {

		medDao.fecharConexao();
		medDao.getEntityManager().close();
		medDao = null;

	};

	public void abrirUniDAO() {

		this.uniDao = new UnidadeDAO();

	};

	public void fecharUniDAO() {

		uniDao.fecharConexao();
		uniDao.getEntityManager().close();
		uniDao = null;

	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(Date horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	};

}
