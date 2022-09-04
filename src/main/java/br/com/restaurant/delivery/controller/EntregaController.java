package br.com.restaurant.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaCompletaVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.service.entrega.EntregaService;

@RestController
@RequestMapping("/restaurante-delivery/entrega")
public class EntregaController {

	@Autowired
	private EntregaService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EntregaCompletaVO criaEntrega(@RequestBody @Valid EntregaVO vo) {
		return service.criaEntrega(vo);
	}
}
