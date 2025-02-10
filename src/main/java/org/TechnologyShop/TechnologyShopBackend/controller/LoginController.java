package org.TechnologyShop.TechnologyShopBackend.controller;

import java.util.Calendar;

import java.util.Date;

import javax.servlet.ServletException;

import org.TechnologyShop.TechnologyShopBackend.config.JwtFilter;
import org.TechnologyShop.TechnologyShopBackend.dto.Token;
import org.TechnologyShop.TechnologyShopBackend.dto.UserLogin;
import org.TechnologyShop.TechnologyShopBackend.dto.UserResponse;
import org.TechnologyShop.TechnologyShopBackend.model.Usuario;
import org.TechnologyShop.TechnologyShopBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	
	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserLogin user) throws ServletException {
        if (usuarioService.validateUser(user)) {
            String token = generateToken(user.getEmail());
            Usuario usuario = usuarioService.getUserByEmail(user.getEmail());
            
            // Retornamos el objeto UserResponse con el token y el usuario
            return ResponseEntity.ok(new UserResponse(token, usuario));
        }
        throw new ServletException("Nombre o contraseña inválidos.");
    }
	 
	
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 1); // El usuario tendra 1 hora logeado.	
		
		
		return Jwts.builder().setSubject(email).claim("role", "user")
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}
	
}
