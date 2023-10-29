package org.springboot.security.jwt.auth.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {
    private Boolean status;
    private String token;
}
