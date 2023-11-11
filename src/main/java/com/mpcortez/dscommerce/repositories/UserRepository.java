package com.mpcortez.dscommerce.repositories;

import com.mpcortez.dscommerce.entities.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCase(@Nonnull String email);
}
