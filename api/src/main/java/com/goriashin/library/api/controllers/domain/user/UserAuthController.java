package com.goriashin.library.api.controllers.domain.user;

import com.goriashin.library.api.controllers.domain.user.model.UserCredentials;
import com.goriashin.library.api.controllers.domain.user.model.AuthResponse;
import com.goriashin.library.api.controllers.domain.user.jwt.JwtUtil;
import com.goriashin.library.common.domain.user.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class UserAuthController {

    private final RegisterService registerService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping(path="/register")
    @Operation(summary = "Зарегистрировать нового пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь зарегистрирован"),
    })
    public ResponseEntity<String> register(@RequestBody UserCredentials request) {
        registerService.register(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User " + request.getUsername() + " registered successfully");
    }

    @PostMapping(path = "/login")
    @Operation(summary = "Получить токен доступа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Токен получен"),
    })
    public ResponseEntity<?> login(@RequestBody UserCredentials request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
