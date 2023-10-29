package org.springboot.security.jwt.auth.constant;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.security.Key;

@RequiredArgsConstructor(access = AccessLevel.NONE)
public class JwtConstant {
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

}
