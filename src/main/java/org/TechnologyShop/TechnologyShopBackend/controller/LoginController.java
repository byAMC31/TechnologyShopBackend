package org.TechnologyShop.TechnologyShopBackend.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.TechnologyShop.TechnologyShopBackend.config.JwtFilter;
import org.TechnologyShop.TechnologyShopBackend.dto.Token;
import org.TechnologyShop.TechnologyShopBackend.dto.UserLogin;
import org.TechnologyShop.TechnologyShopBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public Token loginUser(@RequestBody UserLogin user) throws ServletException {
		if (usuarioService.validateUser(user)) {
			return new Token(generateToken(user.getEmail()));
		} 
		throw new ServletException("Nombre o contraseña invalidos.");
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
