package model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_diretor")
public class Diretor extends Pessoa {

	@OneToOne(mappedBy="diretor")
	private Unidade unidade;

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
