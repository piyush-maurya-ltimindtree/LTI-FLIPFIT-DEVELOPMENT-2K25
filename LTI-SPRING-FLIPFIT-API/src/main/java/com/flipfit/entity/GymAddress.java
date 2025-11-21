package com.flipfit.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class GymAddress {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
