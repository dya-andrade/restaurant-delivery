package br.com.restaurant.delivery.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComidaBebida {
	
	PICADINHO("Picadinho", 25.00),
	MILANESA("Milanesa", 19.00),
	BISTECA("Bisteca", 15.00),
	MACARRAO("Macarrão", 18.00),
	REFRIGERANTE("Refrigerante", 5.00),
	SUCO("Suco", 4.00);
	
	private String descricao;
	private BigDecimal valor;

	ComidaBebida(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = new BigDecimal(valor);
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
}
