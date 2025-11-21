package com.flipfit.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "gymcenter", uniqueConstraints = @UniqueConstraint(columnNames = {"gymCenterId", "gymOwnerId"}))
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

    @OneToMany(mappedBy = "gymCenter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GymSlot> slots;
}
