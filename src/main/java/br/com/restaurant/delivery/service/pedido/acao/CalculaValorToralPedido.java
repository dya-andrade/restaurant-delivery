package br.com.restaurant.delivery.service.pedido.acao;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.model.pedido.Pedido;

@Component
public class CalculaValorToralPedido {
	
	public void calcula(Pedido pedido) {
		pedido.getItensPedido().forEach(i -> i.calculaValorTotal());
		pedido.calculaValorTotal();
	}
}
