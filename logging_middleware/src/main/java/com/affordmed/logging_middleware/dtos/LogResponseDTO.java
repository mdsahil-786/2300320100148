package com.affordmed.logging_middleware.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogResponseDTO {

    private String logID;
    private String message;
}