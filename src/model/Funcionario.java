package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tab_funcionario")
public class Funcionario extends Pessoa {

	
	private String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
