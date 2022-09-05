package br.com.restaurant.delivery.service.pedido.acao;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.model.pedido.Pedido;

public interface FinalizaPedidoNovo {
	
	void finaliza(Pedido pedido, PedidoVO vo);

}
