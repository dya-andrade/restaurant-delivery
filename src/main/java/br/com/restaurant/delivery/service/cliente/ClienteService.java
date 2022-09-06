package br.com.restaurant.delivery.service.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public ClienteVO criaCliente(@Valid ClienteVO vo) {

		clienteDuplicado.valida(vo);

		Cliente cliente = DozerMapper.parseObject(vo, Cliente.class);

		vo = DozerMapper.parseObject(repository.save(cliente), ClienteVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public ClienteVO buscaClientePeloId(Long id) {

		Cliente cliente = localizaCliente.valida(id);

		ClienteVO vo = DozerMapper.parseObject(cliente, ClienteVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public List<ClienteVO> listaTodosClientes() {

		List<ClienteVO> vos = DozerMapper.parseListObjects(repository.findAll(), ClienteVO.class);

		return adicionaLink.adicionaLinkLista(vos);
	}

	public ClienteVO atualizaCliente(@Valid ClienteVO vo, Long id) {
		
		Cliente cliente = localizaCliente.valida(id);

		cliente.atualizaCliente(vo);

		vo = DozerMapper.parseObject(repository.save(cliente), ClienteVO.class);

		return adicionaLink.adicionaLink(vo);
	}

	public void deletaCliente(Long id) {
		
		Cliente cliente = localizaCliente.valida(id);
		
		repository.delete(cliente);
	}
}
