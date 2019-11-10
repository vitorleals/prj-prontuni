package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tab_enfermeiro",schema = "public")
public class Enfermeiro extends Pessoa {

	@NotNull
	@Column(unique = true)
	private String coren;

	private String uf_coren;

	private String areaAtuacao;

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public String getUf_coren() {
		return uf_coren;
	}

	public void setUf_coren(String uf_coren) {
		this.uf_coren = uf_coren;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public String toString() {
		return "Enfermeiro [coren=" + coren + ", uf_coren=" + uf_coren + ", areaAtuacao=" + areaAtuacao + "]";
	}

	
}
