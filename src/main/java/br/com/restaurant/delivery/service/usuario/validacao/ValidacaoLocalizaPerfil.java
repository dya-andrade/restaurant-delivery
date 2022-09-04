package br.com.restaurant.delivery.service.usuario.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.usuario.UsuarioVO;
import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.model.usuario.PerfilAcesso;
import br.com.restaurant.delivery.repository.usuario.PerfilAcessoRepository;

@Component
public class ValidacaoLocalizaPerfil {
	
	@Autowired
	private PerfilAcessoRepository repository;
	
	public PerfilAcesso valida(UsuarioVO vo) {
		PerfilAcesso perfilAcesso = repository.findByDescricao(vo.getPerfilAcesso().getDescricao())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum perfil de acesso encontrado com esta descricao!"));
		
		return perfilAcesso;
	}

}
