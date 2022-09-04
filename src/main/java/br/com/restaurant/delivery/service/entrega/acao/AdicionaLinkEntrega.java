package br.com.restaurant.delivery.service.entrega.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.EntregaController;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaCompletaVO;

@Component
public class AdicionaLinkEntrega {
	
	public EntregaCompletaVO adicionaLink(EntregaCompletaVO vo) {
		vo.add(linkTo(methodOn(EntregaController.class).buscaEntregaPeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<EntregaCompletaVO> adicionaLinkLista(List<EntregaCompletaVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(EntregaController.class).buscaEntregaPeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
