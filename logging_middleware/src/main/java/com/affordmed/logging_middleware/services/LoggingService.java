package com.affordmed.logging_middleware.services;

import com.affordmed.logging_middleware.client.LoggingClient;
import com.affordmed.logging_middleware.dtos.LogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggingService {

    private final AuthService authService;
    private final LoggingClient loggingClient;

    public String log(LogRequestDTO request) {

        String token = authService.getAccessToken();

        return loggingClient.sendLog(
                token,
                request
        );
    }
}