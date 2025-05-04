package com.goriashin.library.api.controllers.auth.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
