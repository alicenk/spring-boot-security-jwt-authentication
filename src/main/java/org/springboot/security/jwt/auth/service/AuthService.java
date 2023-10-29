package org.springboot.security.jwt.auth.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springboot.security.jwt.auth.controller.request.AuthRequest;
import org.springboot.security.jwt.auth.controller.response.AuthResponse;
import org.springboot.security.jwt.auth.exception.InvalidCredentialsException;
import org.springboot.security.jwt.auth.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthResponse login(AuthRequest authRequest){
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(),
            authRequest.getPassword()
        );
        Authentication result = authenticationManager.authenticate(authentication);
        if(result.isAuthenticated()) {
            String jwtToken = jwtTokenProvider.generateToken(result);
            return AuthResponse.builder().status(Boolean.TRUE).token(jwtToken).build();
        }
        throw new InvalidCredentialsException("Kullanici adi veya sifre hatali");
    }
}
