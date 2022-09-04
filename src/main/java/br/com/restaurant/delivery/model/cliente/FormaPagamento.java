package br.com.restaurant.delivery.model.cliente;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FormaPagamento {
	
	CREDITO("Crédito"),
	DEBITO("Débito"),
	DINHEIRO("Dinheiro"),
	VALEREFEICAO("Vale-Refeição"),
	PIX("Pix");
	
	private String descricao;
	
	FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}
}
