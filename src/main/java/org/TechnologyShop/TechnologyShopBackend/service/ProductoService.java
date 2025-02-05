package org.TechnologyShop.TechnologyShopBackend.service;


import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.Repository.ProductosRepository;
import org.TechnologyShop.TechnologyShopBackend.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	public final ProductosRepository productosRepository;
	
	
	@Autowired
	public ProductoService(ProductosRepository productosRepository) {
	this.productosRepository = productosRepository;	
	}//constructor

	
	
	
	public List<Producto> getAllProducts() {
		return productosRepository.findAll();
	}


	//public Producto getProduct(Long id) {
	  //  return productosRepository.findById(id).orElseThrow(
	   // () -> new IllegalArgumentException("El producto con el id [" + id + "] no existe.")
	   // );	} // getProduct

	
	public Producto getProduct(Long id) {
	    Optional<Producto> productoOpt = productosRepository.findById(id);
	    if (productoOpt.isPresent()) {
	        return productoOpt.get();
	    } else {
	        throw new IllegalArgumentException("El producto con el id [" + id + "] no existe.");
	    }
	}



	public Producto deleteProduct(Long id) {
		Producto prod = null;
		if(productosRepository.existsById(id)) {
			prod= productosRepository.findById(id).get();
			productosRepository.deleteById(id);
		}
		return prod;
	}//getProduct


	

	public Producto addProduct(Producto producto) {
		Optional<Producto> prod = productosRepository.findByNombre(producto.getNombre());
		if(prod.isEmpty()) {
			return productosRepository.save(producto);
		}else {
			return null;
		}
	}//addProduct


	
	public Producto updateProduct(
			Long id, 
			String nombre,
			String descripcion,
			String imagen,
			Double precio,
			String categoria) {
		Producto prod = null;
		if(productosRepository.existsById(id)) {		
				Producto producto = productosRepository.findById(id).get();
				if(nombre!=null) producto.setNombre(nombre);
				if(descripcion!=null) producto.setDescripcion(descripcion);
				if(imagen!=null) producto.setImagen(imagen);
				if(precio!=null) producto.setPrecio(precio);
				if(categoria!=null) producto.setCategoria(categoria);	
				prod=producto;
				productosRepository.save(producto);
			}
		return prod;
	}//updateProduct


	
	
}// ProductoService