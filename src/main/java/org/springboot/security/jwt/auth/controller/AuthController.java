package org.springboot.security.jwt.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springboot.security.jwt.auth.controller.request.AuthRequest;
import org.springboot.security.jwt.auth.controller.response.AuthResponse;
import org.springboot.security.jwt.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
