package br.com.restaurant.delivery.service.pedido.acao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.ItemPedidoRepository;

@Component
public class RealizaPersistenciaDoItens {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void realiza(Pedido pedido) {
		List<ItemPedido> itensPedido = pedido.getItensPedido();
		
		itensPedido = itemPedidoRepository.saveAll(itensPedido);
		
		pedido.setItensPedido(itensPedido);
	}

}
