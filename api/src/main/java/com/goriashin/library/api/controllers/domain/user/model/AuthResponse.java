package com.goriashin.library.api.controllers.domain.user.model;

import lombok.Data;

@Data
public class AuthResponse {

    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

}
