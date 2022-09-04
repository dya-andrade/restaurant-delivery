package br.com.restaurant.delivery.service.pedido.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.PedidoRepository;

@Component
public class ValidacaoLocalizaPedido {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido valida(Long id) {
		Pedido pedido = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum pedido encontrado com este ID!"));
		
		return pedido;
	}

}
