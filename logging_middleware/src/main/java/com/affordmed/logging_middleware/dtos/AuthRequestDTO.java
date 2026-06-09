package com.affordmed.logging_middleware.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequestDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String rollNo;

    @NotBlank
    private String accessCode;

    @NotBlank
    private String clientID;

    @NotBlank
    private String clientSecret;
}