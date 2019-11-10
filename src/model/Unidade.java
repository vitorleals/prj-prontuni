package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_unidade")
@SequenceGenerator(name = "UNIDADE_ID", sequenceName = "SEQ_UNIDADE", initialValue = 1, allocationSize = 1)
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_unidade")
	@SequenceGenerator(name = "id_unidade", sequenceName = "seq_unidade", allocationSize = 1)
	private Integer id_unidade;

	private String nome_unidade;

	private String rua;

	private String bairro;

	private String numero;

	private String cep;

	private String cidade;

	private String uf;

	private String telefone;

	private String email;

	@OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
	private List<Agendamento> agendamentos_unidade;

	@OneToOne
	@JoinColumn(name = "diretor")
	private Diretor diretor;

	private String tipo_unidade;

	public Integer getId_unidade() {
		return id_unidade;
	}

	public void setId_unidade(Integer id_unidade) {
		this.id_unidade = id_unidade;
	}

	public String getNome_unidade() {
		return nome_unidade;
	}

	public void setNome_unidade(String nome_unidade) {
		this.nome_unidade = nome_unidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo_unidade() {
		return tipo_unidade;
	}

	public void setTipo_unidade(String tipo_unidade) {
		this.tipo_unidade = tipo_unidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public List<Agendamento> getAgendamentos_unidade() {
		return agendamentos_unidade;
	}

	public void setAgendamentos_unidade(List<Agendamento> agendamentos_unidade) {
		this.agendamentos_unidade = agendamentos_unidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_unidade == null) ? 0 : id_unidade.hashCode());
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
		Unidade other = (Unidade) obj;
		if (id_unidade == null) {
			if (other.id_unidade != null)
				return false;
		} else if (!id_unidade.equals(other.id_unidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Unidade [id_unidade=" + id_unidade + ", nome_unidade=" + nome_unidade + ", rua=" + rua + ", bairro="
				+ bairro + ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + ", telefone="
				+ telefone + ", email=" + email + ", agendamentos_unidade=" + agendamentos_unidade + ", diretor="
				+ diretor + ", tipo_unidade=" + tipo_unidade + "]";
	}

}
