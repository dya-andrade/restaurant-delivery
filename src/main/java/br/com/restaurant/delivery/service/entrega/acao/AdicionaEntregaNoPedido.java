package br.com.restaurant.delivery.service.entrega.acao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.entrega.CadastraEntregaVO;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.service.pedido.validacao.ValidacaoLocalizaPedido;

@Component
public class AdicionaEntregaNoPedido {

	@Autowired
	private ValidacaoLocalizaPedido localizaPedido;


	public void adiciona(Entrega entrega, CadastraEntregaVO vo) {
		List<Pedido> pedidos = vo.getIdPedidos().stream().map(p -> localizaPedido.valida(p.longValue()))
				.collect(Collectors.toList());

		entrega.adicionaPedidos(pedidos);
	}
}
