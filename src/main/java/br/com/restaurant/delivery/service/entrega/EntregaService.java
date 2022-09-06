package br.com.restaurant.delivery.service.entrega;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.entrega.CadastraEntregaVO;
import br.com.restaurant.delivery.data.vo.v1.entrega.EntregaVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.entrega.Entrega;
import br.com.restaurant.delivery.repository.EntregaRepository;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaLinkEntrega;
import br.com.restaurant.delivery.service.entrega.acao.AdicionaEntregaNoPedido;
import br.com.restaurant.delivery.service.entrega.validacao.ValidacaoLocalizaEntrega;

@Service
@Transactional
public class EntregaService {

	@Autowired
	private EntregaRepository repository;

	@Autowired
	private AdicionaEntregaNoPedido adicionaEntregaNoPedido;

	@Autowired
	private AdicionaLinkEntrega adicionaLink;

	@Autowired
	private ValidacaoLocalizaEntrega localizaEntrega;

	public EntregaVO criaEntrega(@Valid CadastraEntregaVO vo) {

		Entrega entrega = DozerMapper.parseObject(vo, Entrega.class);

		return geraEntregaVO(vo, entrega);
	}

	public EntregaVO buscaEntregaPeloId(Long id) {
		Entrega entrega = localizaEntrega.valida(id);

		EntregaVO vo = DozerMapper.parseObject(entrega, EntregaVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public List<EntregaVO> listaTodasEntregas() {

		List<EntregaVO> vos = DozerMapper.parseListObjects(repository.findAll(), EntregaVO.class);

		return adicionaLink.adicionaLinkLista(vos);
	}

	public EntregaVO atualizaEntrega(@Valid CadastraEntregaVO vo, Long id) {

		Entrega entrega = localizaEntrega.valida(id);

		return geraEntregaVO(vo, entrega);
	}

	public void deletaEntrega(Long id) {

		Entrega entrega = localizaEntrega.valida(id);

		repository.delete(entrega);
	}

	private EntregaVO geraEntregaVO(@Valid CadastraEntregaVO vo, Entrega entrega) {
		entrega.atualizaDados(vo);

		adicionaEntregaNoPedido.adiciona(entrega, vo);

		EntregaVO entregaVO = DozerMapper.parseObject(repository.save(entrega), EntregaVO.class);

		return adicionaLink.adicionaLink(entregaVO);
	}
}
