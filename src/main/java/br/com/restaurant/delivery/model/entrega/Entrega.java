package br.com.restaurant.delivery.model.entrega;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import br.com.restaurant.delivery.data.vo.v1.entrega.CadastraEntregaVO;
import br.com.restaurant.delivery.model.pedido.Pedido;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime data;
	
	private String motoboy;
	
	private BigDecimal valor;
	
    @OneToMany
    private List<Pedido> pedidos = new ArrayList<Pedido>();
        
    public void adicionaPedidos(List<Pedido> pedidos) {
    	this.pedidos = pedidos;
    	this.data = LocalDateTime.now();
    }
    
	public void atualizaDados(@Valid CadastraEntregaVO vo) {
		this.motoboy = vo.getMotoboy();
		this.valor = vo.getValor();
	}

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
