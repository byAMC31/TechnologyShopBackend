package org.TechnologyShop.TechnologyShopBackend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.TechnologyShop.TechnologyShopBackend.model.Compra;
import org.TechnologyShop.TechnologyShopBackend.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//http:/localhost:8080/api/compras/
@RequestMapping(path = "/api/compras/")
public class ComprasController {

	private final CompraService compraService;

	@Autowired
	public ComprasController(CompraService compraService) {
		super();
		this.compraService = compraService;
	}

	
	
	// Método para obtener las compras
	@GetMapping
	public List<Compra> getCompra() {
		return compraService.getAllCompras();
	}

	
	
	// Método para obtener una compra por medio del id
	@GetMapping(path = "{compId}")
	public Compra getCompra(@PathVariable("compId") Long id) {
		return compraService.getCompra(id);
	}

	
	
	// Método para eliminar una compra por medio del id
	@DeleteMapping(path = "{compId}")
	public Compra deleteCompra(@PathVariable("compId") Long id) {
		return compraService.deleteCompra(id);
	}// deleteCompra

	
	
	// Método para crear una compra
	@PostMapping
	public Compra addCompra(@RequestBody Compra compra) {
		return compraService.addCompra(compra);
	}// addCompra

	
	
	// Long id, Double total, LocalDateTime fecha, Long usuarioid
	@PutMapping(path = "{compId}")
	public Compra updateCompra(
			@PathVariable("compId") Long id, 
			@RequestParam(required = false) Double total,
			@RequestParam(required = false) LocalDateTime fecha,
			@RequestParam(required = false) Long usuarioid) {
		return compraService.updateCompra(id, total, fecha, usuarioid);
	}// updateCompra

}
