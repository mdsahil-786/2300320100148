package com.affordmed.logging_middleware.client;

import com.affordmed.logging_middleware.dtos.LogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class LoggingClient {

    private final RestTemplate restTemplate;

    private static final String LOG_URL =
            "http://20.244.56.144/evaluation-service/logs";

    public String sendLog(
            String token,
            LogRequestDTO request
    ) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setBearerAuth(token);

        HttpEntity<LogRequestDTO> entity =
                new HttpEntity<>(request, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(
                        LOG_URL,
                        entity,
                        String.class
                );

        return response.getBody();
    }
}