package br.com.concessionaria.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import br.com.concessionaria.model.PessoaModel;
import br.com.concessionaria.model.VendasModel;

public class ClienteDto extends PessoaModel{

	private List<VendasModel> vendas;

	public ClienteDto() {
		
	}

	public ClienteDto(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
		
	}

	public List<VendasModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendasModel> vendas) {
		this.vendas = vendas;
	}
	
	
	
	
}
