package com.flipfit.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flipfit.entity.GymUser;

/**
 * JPA repository for GymUser.
 *
 * @author Mayuresh Arvind Gujar
 */
public interface GymUserRepository extends JpaRepository<GymUser, Long> {

    Optional<GymUser> findByUserNameIgnoreCase(String userName);

    boolean existsByUserNameIgnoreCase(String userName);
}