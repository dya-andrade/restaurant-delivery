package br.com.restaurant.delivery.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurant.delivery.controller.UsuarioController;
import br.com.restaurant.delivery.data.vo.v1.UsuarioVO;
import br.com.restaurant.delivery.exception.PersistenciaEntidadeException;
import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.Usuario;
import br.com.restaurant.delivery.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioVO criaUsuario(@Valid UsuarioVO vo) {

		Optional<Usuario> usuarioDuplicado = repository.findByEmail(vo.getEmail());

		if (usuarioDuplicado.isPresent())
			throw new PersistenciaEntidadeException("Já existe um usuário com este e-mail!");

		Usuario usuario = DozerMapper.parseObject(vo, Usuario.class);

		repository.save(usuario);

		vo.add(linkTo(methodOn(UsuarioController.class).buscaUsuarioPeloEmail(vo.getEmail())).withSelfRel());

		return vo;
	}

	public UsuarioVO buscaUsuarioPeloEmail(String email) {

		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum usuário encontrado com este e-mail!"));

		UsuarioVO vo = DozerMapper.parseObject(usuario, UsuarioVO.class);

		vo.add(linkTo(methodOn(UsuarioController.class).buscaUsuarioPeloEmail(vo.getEmail())).withSelfRel());

		return vo;
	}

	public List<UsuarioVO> listaTodosUsuarios() {

		List<UsuarioVO> vos = DozerMapper.parseListObjects(repository.findAll(), UsuarioVO.class);

		vos.forEach(u -> u
				.add(linkTo(methodOn(UsuarioController.class).buscaUsuarioPeloEmail(u.getEmail())).withSelfRel()));

		return vos;
	}

}
