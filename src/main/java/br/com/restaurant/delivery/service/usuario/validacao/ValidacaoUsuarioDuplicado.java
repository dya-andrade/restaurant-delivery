package br.com.restaurant.delivery.service.usuario.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.usuario.UsuarioVO;
import br.com.restaurant.delivery.exception.ConflitoEntidadeException;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.repository.usuario.UsuarioRepository;

@Component
public class ValidacaoUsuarioDuplicado {

	@Autowired
	private UsuarioRepository repository;
	
	public void valida(UsuarioVO vo) {

		Optional<Usuario> usuarioDuplicado = repository.findByEmail(vo.getEmail());
		
		if (usuarioDuplicado.isPresent())
			throw new ConflitoEntidadeException("Já existe um usuário com este e-mail!");
	}
}
