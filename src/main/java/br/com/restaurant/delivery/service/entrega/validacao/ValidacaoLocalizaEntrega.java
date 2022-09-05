package br.com.restaurant.delivery.service.entrega.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.repository.EntregaRepository;

@Component
public class ValidacaoLocalizaEntrega {
	
	@Autowired
	private EntregaRepository repository;
	
	public Entrega valida(Long id) {
		Entrega entrega = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma entrega encontrada com este ID!"));
		
		return entrega;
	}

}
