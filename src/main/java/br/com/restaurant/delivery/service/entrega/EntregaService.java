package br.com.restaurant.delivery.service.entrega;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.CadastraEntregaVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.repository.EntregaRepository;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaEntregaNoPedido;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaLinkEntrega;
import br.com.restaurant.delivery.service.entrega.validacao.ValidacaoLocalizaEntrega;

@Service
@Transactional
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private AdicionaEntregaNoPedido adicionaEntregaNoPedido;
	
	@Autowired
	private AdicionaLinkEntrega adicionaLink;
	
	@Autowired
	private ValidacaoLocalizaEntrega localizaEntrega;
	

	public EntregaVO criaEntrega(@Valid CadastraEntregaVO vo) {
		
		Entrega entrega = DozerMapper.parseObject(vo, Entrega.class);

		adicionaEntregaNoPedido.adiciona(entrega, vo);
	
		EntregaVO entregaVO = 
				DozerMapper.parseObject(entregaRepository.save(entrega), EntregaVO.class);

		return adicionaLink.adicionaLink(entregaVO);
	}


	public EntregaVO buscaEntregaPeloId(Long id) {
		Entrega entrega = localizaEntrega.valida(id);
		
		EntregaVO vo = 
				DozerMapper.parseObject(entrega, EntregaVO.class);

		return adicionaLink.adicionaLink(vo);
	}


}
