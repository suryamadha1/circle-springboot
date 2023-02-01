package com.social.circle.repositories;

import com.social.circle.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository  extends JpaRepository<User, Long> {
    Set<User> findByEmail(String email);
}
