package org.TechnologyShop.TechnologyShopBackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="detalleDeCompra")
public class DetalleDeCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private Long compraId;
	@Column(nullable=false)
	private Long productoId;
	@Column(nullable=false)
	private int total;

	
	public DetalleDeCompra(Long compraId, Long productoId, int total) {
		this.compraId = compraId;
		this.productoId = productoId;
		this.total = total;
	}//constructor sin id


	public DetalleDeCompra() {}//constructor vacio


	public Long getId() {
		return id;
	}

	public Long getCompraId() {
		return compraId;
	}


	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}


	public Long getProductoId() {
		return productoId;
	}


	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
