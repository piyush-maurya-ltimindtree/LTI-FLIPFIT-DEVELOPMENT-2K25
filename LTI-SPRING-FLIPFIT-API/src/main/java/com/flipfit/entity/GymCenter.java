package com.flipfit.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Class: GymCenter
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"gym_center_id", "gym_owner_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class GymCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long gymCenterId;
    private Long gymOwnerId;
    private String gymCenterName;
    private String gstNumber;

    @Embedded
    private GymAddress address;

    private Integer capacity;
    private Boolean isApproved;
    private Double amountPerSlot;

}
