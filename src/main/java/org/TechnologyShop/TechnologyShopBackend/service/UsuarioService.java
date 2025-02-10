package org.TechnologyShop.TechnologyShopBackend.service;

import java.util.List;
import java.util.Optional;

import org.TechnologyShop.TechnologyShopBackend.Repository.UsuariosRepository;
import org.TechnologyShop.TechnologyShopBackend.dto.ChangePassword;
import org.TechnologyShop.TechnologyShopBackend.dto.UserLogin;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuariosRepository usuariosRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
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
	public Usuario addUser(Usuario usuario) {
		Optional<Usuario> user = usuariosRepository.findByEmail(usuario.getEmail());
		if(user.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			return usuariosRepository.save(usuario);
		}else {
			return null;
		}
	}
	
	// Actualizar usuario
	public Usuario updateUser(Long id, ChangePassword changePassword) {
		Usuario user = null;
		
		if(usuariosRepository.existsById(id)){
			Usuario usuario = usuariosRepository.findById(id).get();
			
			if(encoder.matches(changePassword.getPassword(), usuario.getPassword())) {
				usuario.setPassword(changePassword.getNewPassword());
				user = usuario;
				usuariosRepository.save(usuario);
			}
			return user;
			}
		
		return user;
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
