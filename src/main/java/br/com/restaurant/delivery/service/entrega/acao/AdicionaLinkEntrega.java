package br.com.restaurant.delivery.service.entrega.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.EntregaController;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;

@Component
public class AdicionaLinkEntrega {
	
	public EntregaVO adicionaLink(EntregaVO vo) {
		vo.add(linkTo(methodOn(EntregaController.class).buscaEntregaPeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<EntregaVO> adicionaLinkLista(List<EntregaVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(EntregaController.class).buscaEntregaPeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
