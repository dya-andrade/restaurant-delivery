package br.com.restaurant.delivery.service.pedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.pedido.CadastraPedidoVO;
import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.pedido.ItemPedido;
import br.com.restaurant.delivery.model.pedido.Pedido;
import br.com.restaurant.delivery.repository.PedidoRepository;
import br.com.restaurant.delivery.service.pedido.acao.AdicionaLinkPedido;
import br.com.restaurant.delivery.service.pedido.acao.CriaPedido;
import br.com.restaurant.delivery.service.pedido.acao.FinalizaPedido;
import br.com.restaurant.delivery.service.pedido.validacao.ValidacaoLocalizaPedido;

@Service
@Transactional
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ValidacaoLocalizaPedido localizaPedido;

	@Autowired
	private List<FinalizaPedido> finalizaPedido;
	
	@Autowired
	private List<CriaPedido> criaPedido;

	@Autowired
	private AdicionaLinkPedido adicionaLink;
	
	
	public PedidoVO criaPedido(@Valid CadastraPedidoVO vo) {

		Pedido pedido = new Pedido();
		
		return geraPedidoVO(vo, pedido);
	}

	public PedidoVO buscaPedidoPeloId(Long id) {

		Pedido pedido = localizaPedido.valida(id);

		PedidoVO vo = DozerMapper.parseObject(pedido, PedidoVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public List<PedidoVO> listaTodosPedidos() {
		List<PedidoVO> vos = DozerMapper.parseListObjects(repository.findAll(), PedidoVO.class);

		return adicionaLink.adicionaLinkLista(vos);
	}

	public PedidoVO atualizaPedido(@Valid CadastraPedidoVO vo, Long id) {
		Pedido pedido = localizaPedido.valida(id);
		
		return geraPedidoVO(vo, pedido);	
	}
	
	public void deletaPedido(Long id) {
		Pedido pedido = localizaPedido.valida(id);

		repository.delete(pedido);
	}
	
	private PedidoVO geraPedidoVO(@Valid CadastraPedidoVO vo, Pedido pedido) {
		criaPedido.forEach(f -> f.cria(pedido, vo));
		
		List<ItemPedido> itensPedido = DozerMapper.parseListObjects(vo.getItensPedido(), ItemPedido.class);

		finalizaPedido.forEach(f -> f.finaliza(pedido, itensPedido));

		PedidoVO pedidoVo = DozerMapper.parseObject(repository.save(pedido), PedidoVO.class);

		return adicionaLink.adicionaLink(pedidoVo);
	}
}
