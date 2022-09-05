package br.com.restaurant.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteCompletoVO;
import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;
import br.com.restaurant.delivery.service.cliente.ClienteService;

@RestController
@RequestMapping("/restaurante-delivery/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteCompletoVO criaCliente(@RequestBody @Valid ClienteVO vo) {
		return service.criaCliente(vo);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteCompletoVO buscaClientePeloId(@PathVariable("id") Long id) {
		return service.buscaClientePeloId(id);
	}

}
