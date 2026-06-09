package com.affordmed.logging_middleware.services;

import com.affordmed.logging_middleware.dtos.LogRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    public void log(LogRequestDTO request) {

        System.out.println(
                "[" + request.getLevel() + "] "
                        + request.getPackageName()
                        + " : "
                        + request.getMessage()
        );
    }
}