package br.com.restaurant.delivery.service.pedido.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.PedidoController;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoCompletoVO;

@Component
public class AdicionaLinkPedido {
	
	public PedidoCompletoVO adicionaLink(PedidoCompletoVO vo) {
		vo.add(linkTo(methodOn(PedidoController.class).buscaPedidoPeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<PedidoCompletoVO> adicionaLinkLista(List<PedidoCompletoVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(PedidoController.class).buscaPedidoPeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
