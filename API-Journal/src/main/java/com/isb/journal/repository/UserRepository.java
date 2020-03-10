package com.isb.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isb.journal.entity.relacional.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
