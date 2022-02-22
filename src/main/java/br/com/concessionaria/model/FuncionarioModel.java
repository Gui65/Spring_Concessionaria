package br.com.concessionaria.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "id_gerente")
@Entity
@Table(name = "TB_GERENTE")
public class FuncionarioModel extends PessoaModel{
	
	public FuncionarioModel() {
		
	}
	
	public FuncionarioModel(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
	}
	
	
}
