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

import br.com.restaurant.delivery.data.vo.v1.pedido.ItemPedidoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.service.pedido.PedidoService;

@RestController
@RequestMapping("/restaurante-delivery/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping(value = "/{idCliente}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO criaPedido(@RequestBody @Valid List<ItemPedidoVO> vos, 
			@PathVariable("idCliente") Long idCliente) {
		return service.criaPedido(vos, idCliente);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO buscaPedidoPeloId(@PathVariable("id") Long id) {
		return service.buscaPedidoPeloId(id);
	}
}
