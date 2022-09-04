package br.com.restaurant.delivery.service.usuario.acao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.usuario.UsuarioVO;
import br.com.restaurant.delivery.model.usuario.PerfilAcesso;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.service.usuario.validacao.ValidacaoLocalizaPerfil;

@Component
public class AdicionaPerfilNoUsuario {
	
	@Autowired
	private ValidacaoLocalizaPerfil validacaoLocalizaPerfil;
	
	public void adiciona(Usuario usuario, UsuarioVO vo) {
		PerfilAcesso perfilAcesso = validacaoLocalizaPerfil.valida(vo);
		usuario.setPerfilAcesso(perfilAcesso);
	}
}
