package br.com.restaurant.delivery.service.pedido.acao;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.pedido.CadastraPedidoVO;
import br.com.restaurant.delivery.model.pedido.Pedido;

@Component
public class AplicaDescontoNoPedido implements CriaPedido {
	
	@Override
	public void cria(Pedido pedido, CadastraPedidoVO vo) {
		pedido.aplicaDesconto(vo.getDesconto());
	}
}
