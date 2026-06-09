package com.affordmed.logging_middleware.client;

import com.affordmed.logging_middleware.dtos.AuthRequestDTO;
import com.affordmed.logging_middleware.dtos.AuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AuthClient {

    private final RestTemplate restTemplate;

    private static final String AUTH_URL =
            "http://20.244.56.144/evaluation-service/auth";

    public AuthResponseDTO getToken(AuthRequestDTO request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AuthRequestDTO> entity =
                new HttpEntity<>(request, headers);

        ResponseEntity<AuthResponseDTO> response =
                restTemplate.postForEntity(
                        AUTH_URL,
                        entity,
                        AuthResponseDTO.class
                );

        return response.getBody();
    }
}