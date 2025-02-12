package org.TechnologyShop.TechnologyShopBackend.controller;

import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.model.DetalleDeCompra;

import org.TechnologyShop.TechnologyShopBackend.service.DetallesDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/detallesdecompra/")
public class DetallesDeCompraController {
	
	private final DetallesDeCompraService detallesDeCompraService;
	
	@Autowired
	public DetallesDeCompraController(DetallesDeCompraService detallesDeCompraService) {
		this.detallesDeCompraService = detallesDeCompraService;
	}//constructor
	
	@GetMapping(path = "{compraid}")
	public DetalleDeCompra getDetalles(@PathVariable("compraid") Long compraId){
		return detallesDeCompraService.getDetalleDeCompra(compraId);
		}
	
	@PostMapping
	public DetalleDeCompra addDetalle(@RequestBody DetalleDeCompra detalleDeCompra) {
		return detallesDeCompraService.addDetalle(detalleDeCompra);
	}

	
	
}
