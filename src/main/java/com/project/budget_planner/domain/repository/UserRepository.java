package com.project.budget_planner.domain.repository;

import java.util.List;
import java.util.Optional;

import com.project.budget_planner.domain.model.User;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByPseudo(String pseudo);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}
