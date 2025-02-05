package org.TechnologyShop.TechnologyShopBackend.controller;


import java.util.List;

import org.TechnologyShop.TechnologyShopBackend.model.Producto;
import org.TechnologyShop.TechnologyShopBackend.service.ProductoService;
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
//http:/localhost:8080/api/productos/
@RequestMapping(path = "/api/productos/")
public class ProductosController {

	private final ProductoService productoService;

	@Autowired
	public ProductosController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}// constructor

	// Método para obtener los productos
	@GetMapping
	public List<Producto> getProductos() {
		return productoService.getAllProducts();
	}

	// Método para obtener un producto por medio del id
	@GetMapping(path = "{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long id) {
		return productoService.getProduct(id);
	}

	// Método para eliminar un producto por medio del id
	@DeleteMapping(path = "{prodId}")
	public Producto deleteProducto(@PathVariable("prodId") Long id) {
		return productoService.deleteProduct(id);
	}// deleteProducto

	// Método para crear un producto
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProduct(producto);
	}

	@PutMapping(path = "{prodId}")
	public Producto updateProducto(
			@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String descripcion,
			@RequestParam(required = false) String imagen,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String categoria
			) {
		return productoService.updateProduct(id, nombre, descripcion, imagen, precio, categoria);
	}// updateProducto

}// class ProductosController
