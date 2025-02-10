package org.TechnologyShop.TechnologyShopBackend.service;

import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.Repository.DetallesDeCompraRepository;
import org.TechnologyShop.TechnologyShopBackend.model.DetalleDeCompra;
import org.TechnologyShop.TechnologyShopBackend.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesDeCompraService {
	public final DetallesDeCompraRepository detallesDeCompraRepository;

	
	
	@Autowired
	public DetallesDeCompraService(DetallesDeCompraRepository detallesDeCompraRepository) {
		this.detallesDeCompraRepository = detallesDeCompraRepository;
	}//constructor
	
	public DetalleDeCompra getDetalleDeCompra(Long compraId){
		Optional<DetalleDeCompra> detalles = detallesDeCompraRepository.findById(compraId);
		if(detalles.isPresent()) {
			return detalles.get();
		}else {
			throw new IllegalArgumentException("Los La compra"+ compraId +" no existe");
		}
	}
	
	public DetalleDeCompra addDetalle(DetalleDeCompra detalle) {
			return detallesDeCompraRepository.save(detalle);
	}//addDetalle
	
	
	
	
	
	
	
	
}
