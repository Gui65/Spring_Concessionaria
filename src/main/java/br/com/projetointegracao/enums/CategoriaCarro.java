package br.com.projetointegracao.enums;

public enum CategoriaCarro {
	SEMINOVO("SemiNovo"), NOVO("Novo");

	private String descricao;

	CategoriaCarro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
