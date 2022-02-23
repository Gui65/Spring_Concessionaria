package br.com.concessionaria.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.concessionaria.enums.Role;

@PrimaryKeyJoinColumn(name = "id_cliente")
@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteModel")
	private List<VendasModel> vendas;
 
	public ClienteModel() {
		
	}

	public ClienteModel(String nome, String telefone, String email, String senha) {
		super(nome, telefone, email, senha);
	
	}

	public List<VendasModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendasModel> vendas) {
		this.vendas = vendas;
	}


}
