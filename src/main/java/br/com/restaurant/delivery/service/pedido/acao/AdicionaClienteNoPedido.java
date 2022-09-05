package br.com.restaurant.delivery.service.pedido.acao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.service.cliente.validacao.ValidacaoLocalizaCliente;

@Component
public class AdicionaClienteNoPedido implements FinalizaPedido {

	@Autowired
	private ValidacaoLocalizaCliente localizaCliente;	
	
	@Override
	public void finaliza(Pedido pedido, Long idCliente, List<ItemPedido> itensPedido) {
		Cliente cliente = localizaCliente.valida(idCliente);
		pedido.setCliente(cliente);			
	}
}
