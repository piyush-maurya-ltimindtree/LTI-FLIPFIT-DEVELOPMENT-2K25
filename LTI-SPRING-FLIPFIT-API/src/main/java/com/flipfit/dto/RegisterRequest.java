package com.flipfit.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import com.flipfit.entity.UserRole;
import com.flipfit.entity.UserStatus;

/**
 * Registration payload for creating a new user account.
 *
 * @author Mayuresh Arvind Gujar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message = "username is required")
    @Size(min = 3, max = 100, message = "username must be between 3 and 100 characters")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 100, message = "password must be between 8 and 100 characters")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
        message = "password must contain at least one uppercase letter, one lowercase letter, and one digit"
    )
    private String password;

    @Email(message = "invalid email address")
    @Size(max = 100, message = "email must be at most 100 characters")
    private String email;

    @Size(max = 20, message = "phone must be at most 20 characters")
    @Pattern(
        regexp = "^[0-9+\\-()\\s]*$",
        message = "phone may contain digits, spaces, plus, minus, and parentheses only"
    )
    private String phone;

    @NotNull(message = "role is required")
    private UserRole role;

    /**
     * Optional at registration; defaults to ACTIVE if not provided.
     */
    private UserStatus status;
}