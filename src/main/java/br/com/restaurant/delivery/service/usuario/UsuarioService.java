package br.com.restaurant.delivery.service.usuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.usuario.UsuarioVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.repository.usuario.UsuarioRepository;
import br.com.restaurant.delivery.service.usuario.acao.AdicionaLinkUsuario;
import br.com.restaurant.delivery.service.usuario.acao.AdicionaPerfilNoUsuario;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoLocalizaUsuario;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoUsuarioDuplicado;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ValidacaoLocalizaUsuario localizaUsuario;
	
	@Autowired
	private ValidacaoUsuarioDuplicado usuarioDuplicado;
	
	@Autowired
	private AdicionaLinkUsuario adicionaLink;
	
	@Autowired
	private AdicionaPerfilNoUsuario adicionaPerfilNoUsuario;
	

	public UsuarioVO criaUsuario(@Valid UsuarioVO vo) {

		usuarioDuplicado.valida(vo);
		
		Usuario usuario = DozerMapper.parseObject(vo, Usuario.class);
		
		adicionaPerfilNoUsuario.adiciona(usuario, vo);

		vo = DozerMapper.parseObject(usuarioRepository.save(usuario), UsuarioVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public UsuarioVO buscaUsuarioPeloId(Long id) {

		Usuario usuario = localizaUsuario.valida(id);

		UsuarioVO vo = DozerMapper.parseObject(usuario, UsuarioVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public List<UsuarioVO> listaTodosUsuarios() {

		List<UsuarioVO> vos = DozerMapper.parseListObjects(usuarioRepository.findAll(), UsuarioVO.class);

		return adicionaLink.adicionaLinkLista(vos);
	}

	public UsuarioVO atualizaUsuario(@Valid UsuarioVO vo, Long id) {

		Usuario usuario = localizaUsuario.valida(id);
		
		adicionaPerfilNoUsuario.adiciona(usuario, vo);
		
		usuarioRepository.save(usuario);
		
		return adicionaLink.adicionaLink(vo);
	}

	public void deletaUsuario(Long id) {
		
		Usuario usuario = localizaUsuario.valida(id);

		usuarioRepository.delete(usuario);
	}

}
