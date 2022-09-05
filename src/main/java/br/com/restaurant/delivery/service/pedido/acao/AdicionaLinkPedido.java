package br.com.restaurant.delivery.service.pedido.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.PedidoController;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;

@Component
public class AdicionaLinkPedido {
	
	public PedidoVO adicionaLink(PedidoVO vo) {
		vo.add(linkTo(methodOn(PedidoController.class).buscaPedidoPeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<PedidoVO> adicionaLinkLista(List<PedidoVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(PedidoController.class).buscaPedidoPeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
