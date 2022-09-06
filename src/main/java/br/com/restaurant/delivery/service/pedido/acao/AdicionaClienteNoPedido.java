package br.com.restaurant.delivery.service.pedido.acao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.data.vo.v1.pedido.CadastraPedidoVO;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.service.cliente.validacao.ValidacaoLocalizaCliente;

@Component
public class AdicionaClienteNoPedido implements CriaPedido {

	@Autowired
	private ValidacaoLocalizaCliente localizaCliente;

	@Override
	public void cria(Pedido pedido, CadastraPedidoVO vo) {
		Cliente cliente = localizaCliente.valida(vo.getIdCliente());
		pedido.setCliente(cliente);
	}
}
