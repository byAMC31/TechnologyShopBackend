package org.TechnologyShop.TechnologyShopBackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private Double total;
	@Column(nullable = false)
	private LocalDateTime fecha;
	@Column(nullable=false)
	private Long usuarioid;
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleDeCompra> detalles = new ArrayList<>();

	
	public Compra(Double total, LocalDateTime fecha) {
		this.total = total;
		this.fecha = fecha;
	} 

	public Compra() {
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public List<DetalleDeCompra> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleDeCompra> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", total=" + total + ", fecha=" + fecha ;
	}

 
	
}
