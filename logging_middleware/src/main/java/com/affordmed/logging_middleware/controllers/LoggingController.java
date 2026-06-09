package com.affordmed.logging_middleware.controllers;

import com.affordmed.logging_middleware.dtos.LogRequestDTO;
import com.affordmed.logging_middleware.services.LoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LoggingController {

    private final LoggingService loggingService;

    @PostMapping
    public ResponseEntity<String> createLog(
            @RequestBody LogRequestDTO request
    ) {

        loggingService.log(request);

        return ResponseEntity.ok("Log received");
    }
}