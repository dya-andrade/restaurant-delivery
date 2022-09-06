package br.com.restaurant.delivery.service.pedido.acao;

import br.com.restaurant.delivery.data.vo.v1.pedido.CadastraPedidoVO;
import br.com.restaurant.delivery.model.pedido.Pedido;

public interface CriaPedido {
	
	void cria(Pedido pedido, CadastraPedidoVO vo);
}
