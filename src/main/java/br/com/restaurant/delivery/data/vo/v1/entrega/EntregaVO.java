package br.com.restaurant.delivery.data.vo.v1.entrega;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNull
public class EntregaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String motoboy;
	
	@NotBlank
	private LocalDateTime valor;

	@NotNull
    private List<Long> idPedidos;

	public String getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(String motoboy) {
		this.motoboy = motoboy;
	}

	public LocalDateTime getValor() {
		return valor;
	}

	public void setValor(LocalDateTime valor) {
		this.valor = valor;
	}

	public List<Long> getIdPedidos() {
		return idPedidos;
	}

	public void setIdPedidos(List<Long> idPedidos) {
		this.idPedidos = idPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedidos, motoboy, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntregaVO other = (EntregaVO) obj;
		return Objects.equals(idPedidos, other.idPedidos) && Objects.equals(motoboy, other.motoboy)
				&& Objects.equals(valor, other.valor);
	}
}
