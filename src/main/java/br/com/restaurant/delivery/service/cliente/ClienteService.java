package br.com.restaurant.delivery.service.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteCompletoVO;
import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;
import br.com.restaurant.delivery.mapper.DozerMapper;
import br.com.restaurant.delivery.model.cliente.Cliente;
import br.com.restaurant.delivery.repository.ClienteRepository;
import br.com.restaurant.delivery.service.cliente.acao.AdicionaLinkCliente;
import br.com.restaurant.delivery.service.cliente.validacao.ValidacaoClienteDuplicado;
import br.com.restaurant.delivery.service.cliente.validacao.ValidacaoLocalizaCliente;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ValidacaoClienteDuplicado clienteDuplicado;
	
	@Autowired
	private ValidacaoLocalizaCliente localizaCliente;
	
	@Autowired
	private AdicionaLinkCliente adicionaLink;

	public ClienteCompletoVO criaCliente(@Valid ClienteVO vo) {

		clienteDuplicado.valida(vo);
		
		Cliente cliente = DozerMapper.parseObject(vo, Cliente.class);
		
		ClienteCompletoVO voCompleto = DozerMapper.parseObject(repository.save(cliente), 
				ClienteCompletoVO.class);

		return adicionaLink.adicionaLink(voCompleto);
	}

	public ClienteCompletoVO buscaClientePeloId(Long id) {
		
		Cliente cliente = localizaCliente.valida(id);
		
		ClienteCompletoVO voCompleto = DozerMapper.parseObject(cliente, 
				ClienteCompletoVO.class);
		
		return adicionaLink.adicionaLink(voCompleto);
	}

}
