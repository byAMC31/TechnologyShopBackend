package org.TechnologyShop.TechnologyShopBackend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	public static String secret = "FraseUltraSecretaDelEquipo2CH49";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Request - solicitud
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// Header Authorization
		String authHeader = httpServletRequest.getHeader("Authorization");
		if (("POST".equals(httpServletRequest.getMethod()) && ! httpServletRequest.getRequestURI().contains("/api/usuarios/")) 
				|| ("GET".equals(httpServletRequest.getMethod()) && ! httpServletRequest.getRequestURI().contains("/api/productos/"))
				|| "PUT".equals(httpServletRequest.getMethod()) 
				|| "DELETE".equals(httpServletRequest.getMethod())) {
			// Bearer
			if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
				throw new ServletException("Invalid token 101");
			}
			// Validar token
			String token = authHeader.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
				claims.forEach((key, value)-> System.out.println(key+" "+value));
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("2. Invalid token");
				throw new ServletException("2. Invalid token");
			} 
		}
		chain.doFilter(request, response);
	}
	
	
}
