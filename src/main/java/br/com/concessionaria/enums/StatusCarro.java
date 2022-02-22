package br.com.concessionaria.enums;

public enum StatusCarro {
	VENDIDO("Vendido"), VENDA("Á Venda");
	
	private String descricao;
	
	StatusCarro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
