package br.com.restaurant.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.delivery.data.vo.v1.UsuarioVO;
import br.com.restaurant.delivery.service.UsuarioService;

@RestController
@RequestMapping(value = "/restaurante-delivery/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO criaUsuario(@RequestBody @Valid UsuarioVO vo) {
		return service.criaUsuario(vo);
	}
	
	@GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioVO buscaUsuarioPeloEmail(@PathVariable("email") String email) {
		return service.buscaUsuarioPeloEmail(email);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioVO> listaTodosUsuarios(){
		return service.listaTodosUsuarios();
	}

}
