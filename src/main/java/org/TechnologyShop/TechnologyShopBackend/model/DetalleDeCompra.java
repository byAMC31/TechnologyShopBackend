package org.TechnologyShop.TechnologyShopBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "detalle_de_compra")
public class DetalleDeCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    @JsonBackReference
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)  
    @JsonIgnore
    private Producto producto;  

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    @JsonProperty("precio_unitario")
    private Double precioUnitario;
    
    @Transient  // No se almacena en la base de datos
    @JsonProperty("producto_id")
    private Long productoId;  
    
    public DetalleDeCompra() {}

    public DetalleDeCompra(Producto producto, Integer cantidad, Double precioUnitario) {
        this.producto = producto;  
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Métodos getters y setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    @Override
    public String toString() {
        return "DetalleDeCompra [id=" + id + ", compra=" + compra + ", producto=" + producto + ", cantidad=" + cantidad
                + ", precioUnitario=" + precioUnitario + "]";
    }
}
