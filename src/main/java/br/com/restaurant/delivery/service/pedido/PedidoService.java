package br.com.restaurant.delivery.service.pedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.pedido.ItemPedidoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.PedidoRepository;
import br.com.restaurant.delivery.service.pedido.acao.AdicionaLinkPedido;
import br.com.restaurant.delivery.service.pedido.acao.FinalizaPedido;
import br.com.restaurant.delivery.service.pedido.validacao.ValidacaoLocalizaPedido;

@Service
@Transactional
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ValidacaoLocalizaPedido localizaPedido;

	@Autowired
	private List<FinalizaPedido> finalizaPedido;

	@Autowired
	private AdicionaLinkPedido adicionaLink;
	

	public PedidoVO criaPedido(@Valid List<ItemPedidoVO> vos, Long idCliente) {

		List<ItemPedido> itensPedido = DozerMapper.parseListObjects(vos, ItemPedido.class);

		Pedido pedido = new Pedido();

		finalizaPedido.forEach(f -> f.finaliza(pedido, idCliente, itensPedido));

		PedidoVO vo = DozerMapper.parseObject(pedidoRepository.save(pedido), PedidoVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public PedidoVO buscaPedidoPeloId(Long id) {

		Pedido pedido = localizaPedido.valida(id);

		PedidoVO vo = DozerMapper.parseObject(pedido, PedidoVO.class);

		return adicionaLink.adicionaLink(vo);
	}
}
