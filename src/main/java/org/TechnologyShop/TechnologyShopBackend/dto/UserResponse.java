package org.TechnologyShop.TechnologyShopBackend.dto;

import org.TechnologyShop.TechnologyShopBackend.model.Usuario;

public class UserResponse {
    private String accessToken;
    private Usuario usuario;

    public UserResponse(String accessToken, Usuario usuario) {
        this.accessToken = accessToken;
        this.usuario = usuario;
    }

    // Getters y setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}