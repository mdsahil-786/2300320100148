package com.affordmed.logging_middleware.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogRequestDTO {

    @NotBlank
    private String stack;

    @NotBlank
    private String level;

    @NotBlank
    private String packageName;

    @NotBlank
    private String message;
}