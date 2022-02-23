package br.com.concessionaria.enums;

public enum Role {
	
	ADMIN("Administrador"), USER("Usuário");
	
	private String descricao;
	
	Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
