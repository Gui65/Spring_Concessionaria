package br.com.concessionaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.concessionaria.enums.Role;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "TB_PESSOA")
@SequenceGenerator(allocationSize = 1, name = "pessoa", sequenceName = "sq_pessoa")
public class PessoaModel {

	@Id
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long id;

	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "nr_telefone")
	private String telefone;

	@Column(name = "ml_email")
	private String email;

	@Column(name = "pw_senha")
	private String senha;
	
	@Column(name = "rl_role")
	private Role role;

	public PessoaModel() {
	}

	public PessoaModel(String nome, String telefone, String email, String senha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	 

}
