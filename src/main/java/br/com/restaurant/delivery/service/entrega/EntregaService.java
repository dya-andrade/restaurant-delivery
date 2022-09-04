package br.com.restaurant.delivery.service.entrega;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaCompletaVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.repository.EntregaRepository;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaEntregaNoPedido;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaLinkEntrega;

@Service
@Transactional
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private AdicionaEntregaNoPedido adicionaEntregaNoPedido;
	
	@Autowired
	private AdicionaLinkEntrega adicionaLink;
	

	public EntregaCompletaVO criaEntrega(@Valid EntregaVO vo) {
		
		Entrega entrega = DozerMapper.parseObject(vo, Entrega.class);

		adicionaEntregaNoPedido.adiciona(entrega, vo);
	
		EntregaCompletaVO voCompleto = 
				DozerMapper.parseObject(entregaRepository.save(entrega), EntregaCompletaVO.class);

		return adicionaLink.adicionaLink(voCompleto);
	}


}
