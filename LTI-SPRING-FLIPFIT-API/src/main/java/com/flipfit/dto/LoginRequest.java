package com.flipfit.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Login request payload containing username and password.
 *
 * @author Mayuresh Arvind Gujar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "username is required")
    @Size(min = 3, max = 100, message = "username must be between 3 and 100 characters")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 100, message = "password must be between 8 and 100 characters")
    private String password;
}