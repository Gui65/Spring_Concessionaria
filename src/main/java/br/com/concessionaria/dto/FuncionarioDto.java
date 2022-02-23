package br.com.concessionaria.dto;

import br.com.concessionaria.model.PessoaModel;

public class FuncionarioDto extends PessoaModel{

	public FuncionarioDto() {
		
	}

	public FuncionarioDto(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	
}
