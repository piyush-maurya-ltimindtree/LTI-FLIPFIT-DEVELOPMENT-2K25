package com.flipfit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gymuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "userName", nullable = false, length = 100)
    private String userName;

    @Column(name = "userPassword", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private UserRole role;
}
