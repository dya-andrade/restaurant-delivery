package br.com.restaurant.delivery.service.pedido;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoCompletoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.PedidoRepository;
import br.com.restaurant.delivery.service.cliente.validacao.ValidacaoLocalizaCliente;
import br.com.restaurant.delivery.service.pedido.acao.AdicionaLinkPedido;
import br.com.restaurant.delivery.service.pedido.acao.CalculaValorToralPedido;

@Service
@Transactional
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CalculaValorToralPedido calculaValorToralPedido;

	@Autowired
	private ValidacaoLocalizaCliente localizaCliente;

	@Autowired
	private AdicionaLinkPedido adicionaLink;

	public PedidoCompletoVO criaPedido(@Valid PedidoVO vo) {

		Pedido pedido = DozerMapper.parseObject(vo, Pedido.class);

		calculaValorToralPedido.calcula(pedido);

		Cliente cliente = localizaCliente.valida(vo.getIdCliente());
		pedido.setCliente(cliente);

		PedidoCompletoVO voCompleto = 
				DozerMapper.parseObject(pedidoRepository.save(pedido), PedidoCompletoVO.class);

		return adicionaLink.adicionaLink(voCompleto);
	}

}
