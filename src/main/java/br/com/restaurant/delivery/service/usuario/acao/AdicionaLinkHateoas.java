package br.com.restaurant.delivery.service.usuario.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.UsuarioController;
import br.com.restaurant.delivery.data.vo.v1.UsuarioVO;

@Component
public class AdicionaLinkHateoas {
	
	public UsuarioVO adicionaLink(UsuarioVO vo) {
		vo.add(linkTo(methodOn(UsuarioController.class).buscaUsuarioPeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<UsuarioVO> adicionaLinkLista(List<UsuarioVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(UsuarioController.class).buscaUsuarioPeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
