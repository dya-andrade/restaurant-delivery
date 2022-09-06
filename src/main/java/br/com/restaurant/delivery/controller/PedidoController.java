package br.com.restaurant.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.delivery.data.vo.v1.pedido.CadastraPedidoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.service.pedido.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/restaurante-delivery/pedido")
@Tag(name = "Pedido", description = "Criar, buscar, atualizar e deletar pedidos.")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping(value = "/{idCliente}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO criaPedido(@RequestBody @Valid CadastraPedidoVO vo) {
		return service.criaPedido(vo);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO buscaPedidoPeloId(@PathVariable("id") Long id) {
		return service.buscaPedidoPeloId(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoVO> listaTodosPedidos(){
		return service.listaTodosPedidos();
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO atualizaPedido(@PathVariable("id") Long id, @RequestBody @Valid CadastraPedidoVO vo) {
		return service.atualizaPedido(vo, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletaPedido(@PathVariable("id") Long id){
		service.deletaPedido(id);
		return ResponseEntity.noContent().build();
	}
}
