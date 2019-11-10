package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_usuarios")
@SequenceGenerator(name = "USUARIO_ID", sequenceName = "SEQ_USUARIO", initialValue = 1, allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(generator = "USUARIO_ID", strategy = GenerationType.SEQUENCE)
	private Long id_usuario;

	@Column(unique = true)
	private String login;

	private String senha;

	private String tipoUs;

	@Temporal(TemporalType.DATE)
	private Date data_criacao;

	@OneToOne
	@JoinColumn(name = "PESSOA_ID")
	private Pessoa pessoa;

	public Usuario() {
		super();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUs() {
		return tipoUs;
	}

	public void setTipoUs(String tipoUs) {
		this.tipoUs = tipoUs;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", login=" + login + ", senha=" + senha + ", tipoUs=" + tipoUs
				+ ", data_criacao=" + data_criacao + ", pessoa=" + pessoa + "]";
	}

}
