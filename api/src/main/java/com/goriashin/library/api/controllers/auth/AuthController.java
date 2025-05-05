package com.goriashin.library.api.controllers.auth;

import com.goriashin.library.api.controllers.auth.model.AuthRequest;
import com.goriashin.library.api.controllers.auth.model.AuthResponse;
import com.goriashin.library.api.controllers.auth.jwt.JwtUtil;
import com.goriashin.library.common.domain.user.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthController {

    private final RegisterService registerService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping(path="/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        registerService.register(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User " + request.getUsername() + " registered successfully");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
