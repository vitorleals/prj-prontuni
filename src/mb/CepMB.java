package mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Endereco;

@ManagedBean(name = "cepMB")
@RequestScoped
public class CepMB {

	private List<Endereco> listagem = new ArrayList<Endereco>();
	private Endereco endereco;
	private String cep;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Endereco> getListagem() {
		return listagem;
	}

	public void setListagem(List<Endereco> listagem) {
		this.listagem = listagem;
	}

}
