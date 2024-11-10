package com.project.budget_planner.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.repository.UserRepository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, UUID>, UserRepository {
    Optional<User> findByPseudo(String pseudo);
    Optional<User> findByEmail(String email);
}
