package com.affordmed.logging_middleware.services;

import com.affordmed.logging_middleware.client.AuthClient;
import com.affordmed.logging_middleware.dtos.AuthRequestDTO;
import com.affordmed.logging_middleware.dtos.AuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthClient authClient;

    public String getAccessToken() {

        AuthRequestDTO request = AuthRequestDTO.builder()
                .email("YOUR_EMAIL")
                .name("YOUR_NAME")
                .rollNo("YOUR_ROLLNO")
                .accessCode("YOUR_ACCESS_CODE")
                .clientID("YOUR_CLIENT_ID")
                .clientSecret("YOUR_CLIENT_SECRET")
                .build();

        AuthResponseDTO response =
                authClient.getToken(request);

        return response.getAccessToken();
    }
}