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
		listEspecialidades.put("Cirurgia da M�o", "Cirurgia da M�o");
		listEspecialidades.put("Cirurgia de cabe�a e pesco�o", "Cirurgia de cabe�a e pesco�o");
		listEspecialidades.put("Cirurgia do Aparelho Digestivo", "Cirurgia do Aparelho Digestivo");
		listEspecialidades.put("Cirurgia Geral", "Cirurgia Geral");
		listEspecialidades.put("Cirurgia Pedi�trica", "Cirurgia Pedi�trica");
		listEspecialidades.put("Cirurgia Pl�stica", "Cirurgia Pl�stica");
		listEspecialidades.put("Cirurgia Tor�cica", "Cirurgia Tor�cica");
		listEspecialidades.put("Cirurgia Vascular", "Cirurgia Vascular");
		listEspecialidades.put("Cl�nica M�dica", "Cl�nica M�dica");
		listEspecialidades.put("Coloproctologia", "Coloproctologia");
		listEspecialidades.put("Dermatologia", "Dermatologia");
		listEspecialidades.put("Endocrinologia", "Endocrinologia");
		listEspecialidades.put("Endoscopia", "Endoscopia");
		listEspecialidades.put("Gastroenterologia", "Gastroenterologia");
		listEspecialidades.put("Gen�tica m�dica", "Gen�tica m�dica");
		listEspecialidades.put("Geriatria", "Geriatria");
		listEspecialidades.put("Ginecologia", "Ginecologia");
		listEspecialidades.put("Obstetr�cia", "Obstetr�cia");
		listEspecialidades.put("Hematologia", "Hematologia");
		listEspecialidades.put("Homeopatia", "Homeopatia");
		listEspecialidades.put("Infectologia", "Infectologia");
		listEspecialidades.put("Mastologia", "Mastologia");
		listEspecialidades.put("Medicina de Fam�lia e Comunidade", "Medicina de Fam�lia e Comunidade");
		listEspecialidades.put("Medicina de Emerg�ncia", "Medicina de Emerg�ncia");
		listEspecialidades.put("Medicina do Trabalho", "Medicina do Trabalho");
		listEspecialidades.put("Medicina do Tr�fego", "Medicina do Tr�fego");
		listEspecialidades.put("Medicina Esportiva", "Medicina Esportiva");
		listEspecialidades.put("Medicina F�sica", "Medicina F�sica");
		listEspecialidades.put("Medicina Intensiva", "Medicina Intensiva");
		listEspecialidades.put("Medicina Legal", "Medicina Legal");
		listEspecialidades.put("Per�cia M�dica", "Per�cia M�dica");
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
		listEspecialidades.put("Patologia Cl�nica", "Patologia Cl�nica");
		listEspecialidades.put("Pediatria", "Pediatria");
		listEspecialidades.put("Pneumologia", "Pneumologia");
		listEspecialidades.put("Psiquiatria", "Psiquiatria");
		listEspecialidades.put("Radiologia", "Radiologia");
		listEspecialidades.put("Radioterapia", "Radioterapia");
		listEspecialidades.put("Reumatologia", "Reumatologia");
		listEspecialidades.put("Urologia", "Urologia");

		listAreaAtuacao = new TreeMap<String, String>();
		listAreaAtuacao.put("Administra��o em Sa�de", "Administra��o em Sa�de");
		listAreaAtuacao.put("Alergia e Imunologia Pedi�trica", "Alergia e Imunologia Pedi�trica");
		listAreaAtuacao.put("Angiorradiologia e Cirurgia Endovascular", "Angiorradiologia e Cirurgia Endovascular");
		listAreaAtuacao.put("Atendimento ao Queimado", "Atendimento ao Queimado");
		listAreaAtuacao.put("Cardiologia Pedi�trica", "Cardiologia Pedi�trica");
		listAreaAtuacao.put("Cirurgia Cr�nio-Maxilo-Facial", "Cirurgia Cr�nio-Maxilo-Facial");
		listAreaAtuacao.put("Cirurgia do trauma", "Cirurgia do trauma");
		listAreaAtuacao.put("Cirurgia videolaparosc�pica", "Cirurgia videolaparosc�pica");
		listAreaAtuacao.put("Citopatologia", "Citopatologia");
		listAreaAtuacao.put("Densitometria �ssea", "Densitometria �ssea");
		listAreaAtuacao.put("Dor", "Dor");
		listAreaAtuacao.put("Ecocardiografia", "Ecocardiografia");
		listAreaAtuacao.put("Eletrofisiologia cl�nica invasiva", "Eletrofisiologia cl�nica invasiva");
		listAreaAtuacao.put("Endocrinologia pedi�trica", "Endocrinologia pedi�trica");
		listAreaAtuacao.put("Endoscopia digestiva", "Endoscopia digestiva");
		listAreaAtuacao.put("Endoscopia ginecol�gica", "Endoscopia ginecol�gica");
		listAreaAtuacao.put("Endoscopia respirat�ria", "Endoscopia respirat�ria");
		listAreaAtuacao.put("Ergometria", "Ergometria");
		listAreaAtuacao.put("Foniatria", "Foniatria");
		listAreaAtuacao.put("Gastroenterologia pedi�trica", "Gastroenterologia pedi�trica");
		listAreaAtuacao.put("Gen�tica", "Gen�tica");
		listAreaAtuacao.put("Hansenologia", "Hansenologia");
		listAreaAtuacao.put("Hematologia e hemoterapia pedi�trica", "Hematologia e hemoterapia pedi�trica");
		listAreaAtuacao.put("Hemodin�mica e cardiologia intervencionista",
				"Hemodin�mica e cardiologia intervencionista");
		listAreaAtuacao.put("Hepatologia", "Hepatologia");
		listAreaAtuacao.put("Infectologia hospitalar", "Infectologia hospitalar");
		listAreaAtuacao.put("Infectologia pedi�trica", "Infectologia pedi�trica");
		listAreaAtuacao.put("Mamografia", "Mamografia");
		listAreaAtuacao.put("Medicina de urg�ncia", "Medicina de urg�ncia");
		listAreaAtuacao.put("Medicina do adolescente", "Medicina do adolescente");
		listAreaAtuacao.put("Medicina fetal", "Medicina fetal");
		listAreaAtuacao.put("Medicina intensiva pedi�trica", "Medicina intensiva pedi�trica");
		listAreaAtuacao.put("Nefrologia pedi�trica", "Nefrologia pedi�trica");
		listAreaAtuacao.put("Neonatologia", "Neonatologia");
		listAreaAtuacao.put("Neurofisiologia cl�nica", "Neurofisiologia cl�nica");
		listAreaAtuacao.put("Neurologia pedi�trica", "Neurologia pedi�trica");
		listAreaAtuacao.put("Neurorradiologia", "Neurorradiologia");
		listAreaAtuacao.put("Nutri��o parenteral e enteral", "Nutri��o parenteral e enteral");
		listAreaAtuacao.put("Nutri��o parenteral e enteral pedi�trica", "Nutri��o parenteral e enteral pedi�trica");
		listAreaAtuacao.put("Nutrologia pedi�trica", "Nutrologia pedi�trica");
		listAreaAtuacao.put("Pneumologia pedi�trica", "Pneumologia pedi�trica");
		listAreaAtuacao.put("Psicogeriatria", "Psicogeriatria");
		listAreaAtuacao.put("Psicoterapia", "Psicoterapia");
		listAreaAtuacao.put("Psiquiatria da inf�ncia e adolesc�ncia", "Psiquiatria da inf�ncia e adolesc�ncia");
		listAreaAtuacao.put("Psiquiatria forense", "Psiquiatria forense");
		listAreaAtuacao.put("Radiologia intervencionista e angiorradiologia",
				"Radiologia intervencionista e angiorradiologia");
		listAreaAtuacao.put("Reumatologia pedi�trica", "Reumatologia pedi�trica");
		listAreaAtuacao.put("Transplante de medula �ssea", "Transplante de medula �ssea");
		listAreaAtuacao.put("Ultrassonografia em ginecologia e obstetr�cia",
				"Ultrassonografia em ginecologia e obstetr�cia");

		listUf = new TreeMap<String, String>();
		listUf.put("AC", "Acre");
		listUf.put("AL", "Alagoas");
		listUf.put("AP", "Amap�");
		listUf.put("AM", "Amazonas");
		listUf.put("BA", "Bahia");
		listUf.put("CE", "Cear�");
		listUf.put("DF", "Distrito Federal");
		listUf.put("ES", "Esp�rito Santo");
		listUf.put("GO", "Goi�s");
		listUf.put("MA", "Maranh�o");
		listUf.put("MT", "Mato Grosso");
		listUf.put("MS", "Mato Grosso do Sul");
		listUf.put("MG", "Minas Gerais");
		listUf.put("PA", "Par�");
		listUf.put("PB", "Para�ba");
		listUf.put("PR", "Paran�");
		listUf.put("PE", "Pernambuco");
		listUf.put("PI", "Piau�");
		listUf.put("RJ", "Rio de Janeiro");
		listUf.put("RN", "Rio Grande do Norte");
		listUf.put("RS", "Rio Grande do Sul");
		listUf.put("RO", "Rond�nia");
		listUf.put("RR", "Roraima");
		listUf.put("SC", "Santa Catarina");
		listUf.put("SP", "S�o Paulo");
		listUf.put("SE", "Sergipe");
		listUf.put("TO", "Tocantins");

		listdoencaMental = new TreeMap<String, String>();
		listdoencaMental.put("Ansiedade", "Ansiedade");
		listdoencaMental.put("Depress�o", "Depress�o");
		listdoencaMental.put("Esquizofrenia", "Esquizofrenia");
		listdoencaMental.put("Transtornos alimentares", "Transtornos alimentares");
		listdoencaMental.put("Estresse p�s traum�tico", "Estresse p�s traum�tico");
		listdoencaMental.put("Somatiza��o", "Somatiza��o");
		listdoencaMental.put("Transtorno bipolar", "Transtorno bipolar");
		listdoencaMental.put("Transtorno obsessivo-compulsivo", "Transtorno obsessivo-compulsivo");
		listdoencaMental.put("Disfun��es Sexuais", "Disfun��es Sexuais");

		listAtendimentos = new TreeMap<String, String>();
		listAtendimentos.put("Consulta b�sica", "Consulta");
		listAtendimentos.put("Emerg�ncia", "Emerg�ncia");
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
