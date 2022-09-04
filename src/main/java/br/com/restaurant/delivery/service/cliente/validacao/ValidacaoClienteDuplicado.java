package br.com.restaurant.delivery.service.cliente.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;
import br.com.restaurant.delivery.exception.ConflitoEntidadeException;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.repository.ClienteRepository;

@Component
public class ValidacaoClienteDuplicado {

	@Autowired
	private ClienteRepository repository;
	
	public void valida(ClienteVO vo) {

		Optional<Cliente> clienteDuplicado = repository.findByTelefone(vo.getTelefone());
		
		if (clienteDuplicado.isPresent())
			throw new ConflitoEntidadeException("Já existe um cliente com este telefone!");
	}
	
}
