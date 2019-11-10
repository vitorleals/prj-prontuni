package mb;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.UnidadeDAO;
import model.Agendamento;
import model.Unidade;

@ManagedBean(name = "utilMB")
@ViewScoped
public class UtilMB {

	private Agendamento agendamento;
	private UnidadeDAO uniDao = new UnidadeDAO();

	private SortedMap<String, String> listEspecialidades = new TreeMap<String, String>();
	private SortedMap<String, String> listAreaAtuacao = new TreeMap<String, String>();
	private SortedMap<String, String> listUf = new TreeMap<String, String>();
	private SortedMap<String, String> listdoencaMental = new TreeMap<String, String>();
	private SortedMap<String, String> listAtendimentos = new TreeMap<String, String>();
	private List<Unidade> listUnidade;

	@PostConstruct
	public void init() {


		listEspecialidades = new TreeMap<String, String>();
		listEspecialidades.put("Acupuntura", "Acupuntura");
		listEspecialidades.put("Alergia e Imunologia", "Alergia e Imunologia");
		listEspecialidades.put("Anestesiologia", "Anestesiologia");
		listEspecialidades.put("Angiologia", "Angiologia");
		listEspecialidades.put("Cancerologia ", "Cancerologia ");
		listEspecialidades.put("Cardiologia", "Cardiologia");
		listEspecialidades.put("Cirurgia Cardiovascular", "Cirurgia Cardiovascular");
		listEspecialidades.put("Cirurgia da Mão", "Cirurgia da Mão");
		listEspecialidades.put("Cirurgia de cabeça e pescoço", "Cirurgia de cabeça e pescoço");
		listEspecialidades.put("Cirurgia do Aparelho Digestivo", "Cirurgia do Aparelho Digestivo");
		listEspecialidades.put("Cirurgia Geral", "Cirurgia Geral");
		listEspecialidades.put("Cirurgia Pediátrica", "Cirurgia Pediátrica");
		listEspecialidades.put("Cirurgia Plástica", "Cirurgia Plástica");
		listEspecialidades.put("Cirurgia Torácica", "Cirurgia Torácica");
		listEspecialidades.put("Cirurgia Vascular", "Cirurgia Vascular");
		listEspecialidades.put("Clínica Médica", "Clínica Médica");
		listEspecialidades.put("Coloproctologia", "Coloproctologia");
		listEspecialidades.put("Dermatologia", "Dermatologia");
		listEspecialidades.put("Endocrinologia", "Endocrinologia");
		listEspecialidades.put("Endoscopia", "Endoscopia");
		listEspecialidades.put("Gastroenterologia", "Gastroenterologia");
		listEspecialidades.put("Genética médica", "Genética médica");
		listEspecialidades.put("Geriatria", "Geriatria");
		listEspecialidades.put("Ginecologia", "Ginecologia");
		listEspecialidades.put("Obstetrícia", "Obstetrícia");
		listEspecialidades.put("Hematologia", "Hematologia");
		listEspecialidades.put("Homeopatia", "Homeopatia");
		listEspecialidades.put("Infectologia", "Infectologia");
		listEspecialidades.put("Mastologia", "Mastologia");
		listEspecialidades.put("Medicina de Família e Comunidade", "Medicina de Família e Comunidade");
		listEspecialidades.put("Medicina de Emergência", "Medicina de Emergência");
		listEspecialidades.put("Medicina do Trabalho", "Medicina do Trabalho");
		listEspecialidades.put("Medicina do Tráfego", "Medicina do Tráfego");
		listEspecialidades.put("Medicina Esportiva", "Medicina Esportiva");
		listEspecialidades.put("Medicina Física", "Medicina Física");
		listEspecialidades.put("Medicina Intensiva", "Medicina Intensiva");
		listEspecialidades.put("Medicina Legal", "Medicina Legal");
		listEspecialidades.put("Perícia Médica", "Perícia Médica");
		listEspecialidades.put("Medicina Nuclear", "Medicina Nuclear");
		listEspecialidades.put("Medicina Preventiva", "Medicina Preventiva");
		listEspecialidades.put("Nefrologia", "Nefrologia");
		listEspecialidades.put("Neurocirurgia", "Neurocirurgia");
		listEspecialidades.put("Neurologia", "Neurologia");
		listEspecialidades.put("Nutrologia", "Nutrologia");
		listEspecialidades.put("Oftalmologia", "Oftalmologia");
		listEspecialidades.put("Ortopedia e Traumatologia", "Ortopedia e Traumatologia");
		listEspecialidades.put("Otorrinolaringologia", "Otorrinolaringologia");
		listEspecialidades.put("Patologia", "Patologia");
		listEspecialidades.put("Patologia Clínica", "Patologia Clínica");
		listEspecialidades.put("Pediatria", "Pediatria");
		listEspecialidades.put("Pneumologia", "Pneumologia");
		listEspecialidades.put("Psiquiatria", "Psiquiatria");
		listEspecialidades.put("Radiologia", "Radiologia");
		listEspecialidades.put("Radioterapia", "Radioterapia");
		listEspecialidades.put("Reumatologia", "Reumatologia");
		listEspecialidades.put("Urologia", "Urologia");

		listAreaAtuacao = new TreeMap<String, String>();
		listAreaAtuacao.put("Administração em Saúde", "Administração em Saúde");
		listAreaAtuacao.put("Alergia e Imunologia Pediátrica", "Alergia e Imunologia Pediátrica");
		listAreaAtuacao.put("Angiorradiologia e Cirurgia Endovascular", "Angiorradiologia e Cirurgia Endovascular");
		listAreaAtuacao.put("Atendimento ao Queimado", "Atendimento ao Queimado");
		listAreaAtuacao.put("Cardiologia Pediátrica", "Cardiologia Pediátrica");
		listAreaAtuacao.put("Cirurgia Crânio-Maxilo-Facial", "Cirurgia Crânio-Maxilo-Facial");
		listAreaAtuacao.put("Cirurgia do trauma", "Cirurgia do trauma");
		listAreaAtuacao.put("Cirurgia videolaparoscópica", "Cirurgia videolaparoscópica");
		listAreaAtuacao.put("Citopatologia", "Citopatologia");
		listAreaAtuacao.put("Densitometria óssea", "Densitometria óssea");
		listAreaAtuacao.put("Dor", "Dor");
		listAreaAtuacao.put("Ecocardiografia", "Ecocardiografia");
		listAreaAtuacao.put("Eletrofisiologia clínica invasiva", "Eletrofisiologia clínica invasiva");
		listAreaAtuacao.put("Endocrinologia pediátrica", "Endocrinologia pediátrica");
		listAreaAtuacao.put("Endoscopia digestiva", "Endoscopia digestiva");
		listAreaAtuacao.put("Endoscopia ginecológica", "Endoscopia ginecológica");
		listAreaAtuacao.put("Endoscopia respiratória", "Endoscopia respiratória");
		listAreaAtuacao.put("Ergometria", "Ergometria");
		listAreaAtuacao.put("Foniatria", "Foniatria");
		listAreaAtuacao.put("Gastroenterologia pediátrica", "Gastroenterologia pediátrica");
		listAreaAtuacao.put("Genética", "Genética");
		listAreaAtuacao.put("Hansenologia", "Hansenologia");
		listAreaAtuacao.put("Hematologia e hemoterapia pediátrica", "Hematologia e hemoterapia pediátrica");
		listAreaAtuacao.put("Hemodinâmica e cardiologia intervencionista",
				"Hemodinâmica e cardiologia intervencionista");
		listAreaAtuacao.put("Hepatologia", "Hepatologia");
		listAreaAtuacao.put("Infectologia hospitalar", "Infectologia hospitalar");
		listAreaAtuacao.put("Infectologia pediátrica", "Infectologia pediátrica");
		listAreaAtuacao.put("Mamografia", "Mamografia");
		listAreaAtuacao.put("Medicina de urgência", "Medicina de urgência");
		listAreaAtuacao.put("Medicina do adolescente", "Medicina do adolescente");
		listAreaAtuacao.put("Medicina fetal", "Medicina fetal");
		listAreaAtuacao.put("Medicina intensiva pediátrica", "Medicina intensiva pediátrica");
		listAreaAtuacao.put("Nefrologia pediátrica", "Nefrologia pediátrica");
		listAreaAtuacao.put("Neonatologia", "Neonatologia");
		listAreaAtuacao.put("Neurofisiologia clínica", "Neurofisiologia clínica");
		listAreaAtuacao.put("Neurologia pediátrica", "Neurologia pediátrica");
		listAreaAtuacao.put("Neurorradiologia", "Neurorradiologia");
		listAreaAtuacao.put("Nutrição parenteral e enteral", "Nutrição parenteral e enteral");
		listAreaAtuacao.put("Nutrição parenteral e enteral pediátrica", "Nutrição parenteral e enteral pediátrica");
		listAreaAtuacao.put("Nutrologia pediátrica", "Nutrologia pediátrica");
		listAreaAtuacao.put("Pneumologia pediátrica", "Pneumologia pediátrica");
		listAreaAtuacao.put("Psicogeriatria", "Psicogeriatria");
		listAreaAtuacao.put("Psicoterapia", "Psicoterapia");
		listAreaAtuacao.put("Psiquiatria da infância e adolescência", "Psiquiatria da infância e adolescência");
		listAreaAtuacao.put("Psiquiatria forense", "Psiquiatria forense");
		listAreaAtuacao.put("Radiologia intervencionista e angiorradiologia",
				"Radiologia intervencionista e angiorradiologia");
		listAreaAtuacao.put("Reumatologia pediátrica", "Reumatologia pediátrica");
		listAreaAtuacao.put("Transplante de medula óssea", "Transplante de medula óssea");
		listAreaAtuacao.put("Ultrassonografia em ginecologia e obstetrícia",
				"Ultrassonografia em ginecologia e obstetrícia");

		listUf = new TreeMap<String, String>();
		listUf.put("AC", "Acre");
		listUf.put("AL", "Alagoas");
		listUf.put("AP", "Amapá");
		listUf.put("AM", "Amazonas");
		listUf.put("BA", "Bahia");
		listUf.put("CE", "Ceará");
		listUf.put("DF", "Distrito Federal");
		listUf.put("ES", "Espírito Santo");
		listUf.put("GO", "Goiás");
		listUf.put("MA", "Maranhão");
		listUf.put("MT", "Mato Grosso");
		listUf.put("MS", "Mato Grosso do Sul");
		listUf.put("MG", "Minas Gerais");
		listUf.put("PA", "Pará");
		listUf.put("PB", "Paraíba");
		listUf.put("PR", "Paraná");
		listUf.put("PE", "Pernambuco");
		listUf.put("PI", "Piauí");
		listUf.put("RJ", "Rio de Janeiro");
		listUf.put("RN", "Rio Grande do Norte");
		listUf.put("RS", "Rio Grande do Sul");
		listUf.put("RO", "Rondônia");
		listUf.put("RR", "Roraima");
		listUf.put("SC", "Santa Catarina");
		listUf.put("SP", "São Paulo");
		listUf.put("SE", "Sergipe");
		listUf.put("TO", "Tocantins");

		listdoencaMental = new TreeMap<String, String>();
		listdoencaMental.put("Ansiedade", "Ansiedade");
		listdoencaMental.put("Depressão", "Depressão");
		listdoencaMental.put("Esquizofrenia", "Esquizofrenia");
		listdoencaMental.put("Transtornos alimentares", "Transtornos alimentares");
		listdoencaMental.put("Estresse pós traumático", "Estresse pós traumático");
		listdoencaMental.put("Somatização", "Somatização");
		listdoencaMental.put("Transtorno bipolar", "Transtorno bipolar");
		listdoencaMental.put("Transtorno obsessivo-compulsivo", "Transtorno obsessivo-compulsivo");
		listdoencaMental.put("Disfunções Sexuais", "Disfunções Sexuais");

		listAtendimentos = new TreeMap<String, String>();
		listAtendimentos.put("Consulta básica", "Consulta");
		listAtendimentos.put("Emergência", "Emergência");
		listAtendimentos.put("Retorno", "Retorno");
		listAtendimentos.put("Outro", "Outro");
	}

	public SortedMap<String, String> getListEspecialidades() {
		return listEspecialidades;
	}

	public void setListEspecialidades(SortedMap<String, String> listEspecialidades) {
		this.listEspecialidades = listEspecialidades;
	}

	public SortedMap<String, String> getListAreaAtuacao() {
		return listAreaAtuacao;
	}

	public void setListAreaAtuacao(SortedMap<String, String> listAreaAtuacao) {
		this.listAreaAtuacao = listAreaAtuacao;
	}

	public SortedMap<String, String> getListUf() {
		return listUf;
	}

	public void setListUf(SortedMap<String, String> listUf) {
		this.listUf = listUf;
	}

	public SortedMap<String, String> getListdoencaMental() {
		return listdoencaMental;
	}

	public void setListdoencaMental(SortedMap<String, String> listdoencaMental) {
		this.listdoencaMental = listdoencaMental;
	}

	public UnidadeDAO getUniDao() {
		return uniDao;
	}

	public void setUniDao(UnidadeDAO uniDao) {
		this.uniDao = uniDao;
	}

	public List<Unidade> getListUnidade() {
		return listUnidade;
	}

	public void setListUnidade(List<Unidade> listUnidade) {
		this.listUnidade = listUnidade;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public SortedMap<String, String> getListAtendimentos() {
		return listAtendimentos;
	}

	public void setListAtendimentos(SortedMap<String, String> listAtendimentos) {
		this.listAtendimentos = listAtendimentos;
	}

}
