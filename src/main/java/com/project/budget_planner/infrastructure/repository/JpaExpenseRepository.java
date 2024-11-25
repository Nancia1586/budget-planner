package com.project.budget_planner.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.budget_planner.domain.model.Expense;
import com.project.budget_planner.domain.repository.ExpenseRepository;

@Repository
public interface JpaExpenseRepository extends JpaRepository<Expense, Long>, ExpenseRepository {
    
}
