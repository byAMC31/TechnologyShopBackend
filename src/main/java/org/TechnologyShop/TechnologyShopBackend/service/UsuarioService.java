package org.TechnologyShop.TechnologyShopBackend.service;

import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.Repository.UsuariosRepository;
import org.TechnologyShop.TechnologyShopBackend.dto.ChangePassword;
import org.TechnologyShop.TechnologyShopBackend.dto.UserLogin;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuariosRepository usuariosRepository;
	
	@Autowired
	public UsuarioService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	
	// Obtener todos los usuarios
	public List<Usuario> getAllUsers() {
		return usuariosRepository.findAll();
	}
	
	// Obtener 1 usuario
	public Usuario getUser(Long id) {
		if (usuariosRepository.existsById(id)) {
			return usuariosRepository.findById(id).get();
		}
		return null;
	}
	
	
	// Obtener 1 usuario por email
	public Usuario getUserByEmail(String email) {
	    return usuariosRepository.findByEmail(email).orElse(null); 
	}


	// Borrar usuario
	public Usuario delUser(Long id) {
		Usuario usr = getUser(id);
		if (usr != null ) {
			usuariosRepository.deleteById(id);
		}
		return usr;
	}
	
	// Añadir usuario
	public Usuario addUser(Usuario usr) {
		Optional<Usuario> user = usuariosRepository.findByEmail(usr.getEmail());
		if (user.isEmpty()) {
			return usuariosRepository.save(usr);
		}
		return null;
	}
	
	// Actualizar usuario
	public Usuario updateUser(ChangePassword new_pass) {
		Optional<Usuario> user = usuariosRepository.findByEmail(new_pass.getEmail());
		if (user.isPresent()) {
			Usuario usr = user.get();
			if (usr.getPassword().equals(new_pass.getPassword())) {
				usr.setPassword(new_pass.getNewPassword());
				usuariosRepository.save(usr);
				return usr;
			}
		}
		return null;
	}

	public boolean validateUser(UserLogin user) {
		Optional<Usuario> usr = usuariosRepository.findByEmail(user.getEmail());
		if (usr.isPresent()) {
			Usuario usuario = usr.get();
			if (user.getPassword().equals(usuario.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
