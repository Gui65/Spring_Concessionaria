package br.com.concessionaria.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "id_gerente")
@Entity
@Table(name = "TB_GERENTE")
public class GerenteModel extends PessoaModel{

	public GerenteModel(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	
}
