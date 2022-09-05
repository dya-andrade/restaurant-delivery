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

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoCompletoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.service.pedido.PedidoService;

@RestController
@RequestMapping("/restaurante-delivery/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoCompletoVO criaPedido(@RequestBody @Valid PedidoVO vo) {
		return service.criaPedido(vo);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoCompletoVO buscaPedidoPeloId(@PathVariable("id") Long id) {
		return service.buscaPedidoPeloId(id);
	}
}
