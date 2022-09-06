package br.com.restaurant.delivery.data.vo.v1.entrega;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;

public class EntregaVO extends RepresentationModel<EntregaVO>  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private LocalDateTime data;
	
	private String motoboy;
	
	private BigDecimal valor;
	
    private List<PedidoVO> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(String motoboy) {
		this.motoboy = motoboy;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<PedidoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoVO> pedidos) {
		this.pedidos = pedidos;
	}
}
