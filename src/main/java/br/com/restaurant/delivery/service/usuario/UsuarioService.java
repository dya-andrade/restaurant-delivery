package br.com.restaurant.delivery.service.usuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.UsuarioVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.usuario.PerfilAcesso;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.repository.UsuarioRepository;
import br.com.restaurant.delivery.service.usuario.acao.AdicionaLinkHateoas;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoLocalizaPerfil;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoLocalizaUsuario;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoUsuarioDuplicado;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ValidacaoLocalizaUsuario validacaoLocalizaUsuario;
	
	@Autowired
	private ValidacaoLocalizaPerfil validacaoLocalizaPerfil;
	
	@Autowired
	private ValidacaoUsuarioDuplicado validacaoUsuarioDuplicado;
	
	@Autowired
	private AdicionaLinkHateoas adicionaLinkHateoas;
	

	public UsuarioVO criaUsuario(@Valid UsuarioVO vo) {

		validacaoUsuarioDuplicado.valida(vo);

		PerfilAcesso perfilAcesso = validacaoLocalizaPerfil.valida(vo);
		
		Usuario usuario = DozerMapper.parseObject(vo, Usuario.class);
		
		usuario.setPerfilAcesso(perfilAcesso);
		
		vo = DozerMapper.parseObject(usuarioRepository.save(usuario), UsuarioVO.class);

		return adicionaLinkHateoas.adicionaLink(vo);
	}

	public UsuarioVO buscaUsuarioPeloId(Long id) {

		Usuario usuario = validacaoLocalizaUsuario.valida(id);

		UsuarioVO vo = DozerMapper.parseObject(usuario, UsuarioVO.class);

		return adicionaLinkHateoas.adicionaLink(vo);
	}

	public List<UsuarioVO> listaTodosUsuarios() {

		List<UsuarioVO> vos = DozerMapper.parseListObjects(usuarioRepository.findAll(), UsuarioVO.class);

		return adicionaLinkHateoas.adicionaLinkLista(vos);
	}

	public UsuarioVO atualizaUsuario(@Valid UsuarioVO vo, Long id) {

		Usuario usuario = validacaoLocalizaUsuario.valida(id);
		
		PerfilAcesso perfilAcesso = validacaoLocalizaPerfil.valida(vo);
		
		usuario.setPerfilAcesso(perfilAcesso);
		
		usuarioRepository.save(usuario);
		
		return adicionaLinkHateoas.adicionaLink(vo);
	}

	public void deletaUsuario(Long id) {
		
		Usuario usuario = validacaoLocalizaUsuario.valida(id);

		usuarioRepository.delete(usuario);
	}

}
