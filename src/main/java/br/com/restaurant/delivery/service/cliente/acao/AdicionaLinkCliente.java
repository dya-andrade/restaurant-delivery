package br.com.restaurant.delivery.service.cliente.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.ClienteController;
import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteCompletoVO;

@Component
public class AdicionaLinkCliente {
	
	public ClienteCompletoVO adicionaLink(ClienteCompletoVO vo) {
		vo.add(linkTo(methodOn(ClienteController.class).buscaClientePeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<ClienteCompletoVO> adicionaLinkLista(List<ClienteCompletoVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(ClienteController.class).buscaClientePeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
