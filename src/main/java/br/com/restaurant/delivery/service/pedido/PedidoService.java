package br.com.restaurant.delivery.service.pedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoCompletoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.PedidoRepository;
import br.com.restaurant.delivery.service.pedido.acao.AdicionaLinkPedido;
import br.com.restaurant.delivery.service.pedido.acao.FinalizaPedidoNovo;
import br.com.restaurant.delivery.service.pedido.acao.RealizaPersistenciaDoItens;
import br.com.restaurant.delivery.service.pedido.validacao.ValidacaoLocalizaPedido;

@Service
@Transactional
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private RealizaPersistenciaDoItens persistenciaDoItens;	
	
	@Autowired
	private List<FinalizaPedidoNovo> finalizaPedidoNovo;
	
	@Autowired
	private ValidacaoLocalizaPedido localizaPedido;

	@Autowired
	private AdicionaLinkPedido adicionaLink;

	public PedidoCompletoVO criaPedido(@Valid PedidoVO vo) {

		Pedido pedido = DozerMapper.parseObject(vo, Pedido.class);
		
		persistenciaDoItens.realiza(pedido);

		finalizaPedidoNovo.forEach(r -> r.finaliza(pedido, vo));
				
		PedidoCompletoVO voCompleto = 
				DozerMapper.parseObject(pedidoRepository.save(pedido), PedidoCompletoVO.class);

		return adicionaLink.adicionaLink(voCompleto);
	}

	public PedidoCompletoVO buscaPedidoPeloId(Long id) {

		Pedido pedido = localizaPedido.valida(id);
		
		PedidoCompletoVO voCompleto = 
				DozerMapper.parseObject(pedido, PedidoCompletoVO.class);

		return adicionaLink.adicionaLink(voCompleto);
	}

}
