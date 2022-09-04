package br.com.restaurant.delivery.service.cliente.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.repository.ClienteRepository;

@Component
public class ValidacaoLocalizaCliente {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente valida(Long id) {
		Cliente cliente = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum cliente encontrado com este ID!"));
		
		return cliente;
	}

}
