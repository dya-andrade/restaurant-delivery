package br.com.restaurant.delivery.data.vo.v1.entrega;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNull
public class CadastraEntregaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String motoboy;
	
	@NotNull
	private BigDecimal valor;

	@NotNull
    private List<Long> idPedidos;

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

	public List<Long> getIdPedidos() {
		return idPedidos;
	}

	public void setIdPedidos(List<Long> idPedidos) {
		this.idPedidos = idPedidos;
	}
}
