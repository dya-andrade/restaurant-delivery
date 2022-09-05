package br.com.restaurant.delivery.service.pedido.acao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;

@Component
public class CalculaValorTotalPedido implements FinalizaPedido {

	@Override
	public void finaliza(Pedido pedido, Long idCliente, List<ItemPedido> itensPedido) {

		itensPedido.forEach(i -> i.calculaValorTotal());
		itensPedido.forEach(i -> i.setPedido(pedido));

		pedido.setItensPedido(itensPedido);
		pedido.calculaValorTotal();
	}
}
