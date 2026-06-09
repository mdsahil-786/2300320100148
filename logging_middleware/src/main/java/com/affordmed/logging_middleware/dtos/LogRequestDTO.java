package com.affordmed.logging_middleware.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogRequestDTO {

    private String stack;
    private String level;
    private String packageName;
    private String message;
}