package org.TechnologyShop.TechnologyShopBackend.controller;

import java.util.List;

import org.TechnologyShop.TechnologyShopBackend.dto.ChangePassword;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.TechnologyShop.TechnologyShopBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	// Obtener todos los usuarios
	@GetMapping 
	public List<Usuario> getAllUsers() {
		return usuarioService.getAllUsers();
	}
	
	// Obtener 1 usuario
	@GetMapping(path="{id}")
	public Usuario getUser(@PathVariable("id") Long id) {
		return usuarioService.getUser(id);
	}
	
	// Borrar usuario
	@DeleteMapping(path = "{id}")
	public Usuario delUser(@PathVariable("id") Long id) {
		return usuarioService.delUser(id);
	}
	
	// Añadir usuario
	@PostMapping
	public Usuario addUser(@RequestBody Usuario usuario) {
		return usuarioService.addUser(usuario);
	}
	
	// Actualizar usuario
	@PutMapping
	public Usuario updateUser(@RequestBody ChangePassword new_pass) {
		return usuarioService.updateUser(new_pass);
	}
}
