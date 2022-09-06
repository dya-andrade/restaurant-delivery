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

import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;
import br.com.restaurant.delivery.service.cliente.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/restaurante-delivery/cliente")
@Tag(name = "Cliente", description = "Criar, buscar, atualizar e deletar clientes.")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO criaCliente(@RequestBody @Valid ClienteVO vo) {
		return service.criaCliente(vo);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO buscaClientePeloId(@PathVariable("id") Long id) {
		return service.buscaClientePeloId(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVO> listaTodosClientes(){
		return service.listaTodosClientes();
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO atualizaCliente(@PathVariable("id") Long id, @RequestBody @Valid ClienteVO vo) {
		return service.atualizaCliente(vo, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletaCliente(@PathVariable("id") Long id){
		service.deletaCliente(id);
		return ResponseEntity.noContent().build();
	}
}
