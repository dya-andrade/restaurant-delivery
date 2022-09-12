package br.com.restaurant.delivery.service.cliente.acao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.EntregaRepository;
import br.com.restaurant.delivery.repository.PedidoRepository;

@Component
public class DeletaRelacionamentosCliente {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public void deleta(Cliente cliente) {
		List<Pedido> pedidos = pedidoRepository.findByCliente(cliente);
		
		//List<Long> idPedidos = pedidos.stream().map(p -> p.getId()).collect(Collectors.toList());
		
		pedidos.forEach(p -> entregaRepository.deletaPedidoEntrega(p.getId()));
		
		pedidoRepository.deleteAll(pedidos);
	}
}
