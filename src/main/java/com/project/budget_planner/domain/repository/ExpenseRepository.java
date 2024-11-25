package com.project.budget_planner.domain.repository;

import java.util.List;
import java.util.Optional;

import com.project.budget_planner.domain.model.Expense;

public interface ExpenseRepository {
    Optional<Expense> findById(Long id);
    List<Expense> findAll();
    Expense save(Expense expense);
    void deleteById(Long id);
}
