package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader("Authorization") String authHeader) {
        System.out.println("====== Inside /authenticate endpoint ======");

        if (authHeader == null) {
            throw new IllegalArgumentException("Missing Authorization header");
        }

        try {
            String user = getUser(authHeader);
            String token = generateJwt(user);

            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }


    private String getUser(String authHeader) {
        String base64Credentials = authHeader.replace("Basic ", "");
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        return decoded.split(":")[0];
    }

    private String generateJwt(String user) {
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 mins
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }
}