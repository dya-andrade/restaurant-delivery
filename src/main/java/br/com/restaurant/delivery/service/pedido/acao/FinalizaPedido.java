package br.com.restaurant.delivery.service.pedido.acao;

import java.util.List;

import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;

public interface FinalizaPedido {
	
	void finaliza(Pedido pedido, Long idCliente, List<ItemPedido> itensPedido);

}
