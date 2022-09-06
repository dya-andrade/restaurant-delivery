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

import br.com.restaurant.delivery.data.vo.v1.entrega.CadastraEntregaVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.service.entrega.EntregaService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/restaurante-delivery/entrega")
@Tag(name = "Entrega", description = "Criar, buscar, atualizar e deletar entregas.")
public class EntregaController {

	@Autowired
	private EntregaService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EntregaVO criaEntrega(@RequestBody @Valid CadastraEntregaVO vo) {
		return service.criaEntrega(vo);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntregaVO buscaEntregaPeloId(@PathVariable("id") Long id) {
		return service.buscaEntregaPeloId(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EntregaVO> listaTodasEntregas(){
		return service.listaTodasEntregas();
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EntregaVO atualizaEntrega(@PathVariable("id") Long id, @RequestBody @Valid CadastraEntregaVO vo) {
		return service.atualizaEntrega(vo, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletaEntrega(@PathVariable("id") Long id){
		service.deletaEntrega(id);
		return ResponseEntity.noContent().build();
	}
}
