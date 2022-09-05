package br.com.restaurant.delivery.service.pedido.acao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;

@Component
public class CalculaValorTotalPedido implements FinalizaPedidoNovo {
	
	@Override
	public void finaliza(Pedido pedido, PedidoVO vo) {
		
		List<ItemPedido> itensPedido = pedido.getItensPedido();
	
		itensPedido.forEach(i -> i.calculaValorTotal());
		
		pedido.setItensPedido(itensPedido);
		pedido.calculaValorTotal();
	}
}
