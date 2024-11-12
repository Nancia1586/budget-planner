package com.project.budget_planner.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.project.budget_planner.domain.model.enums.ExpenseEnum.Frequency;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense extends Transaction {
    
    public Expense() {
        super();
    }

    public Expense(
        Long id,
        User user,
        String designation,
        String description,
        Frequency frequency,
        double frequencyValue,
        double amount,
        LocalDate startDate,
        LocalDate endDate,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
    ) {
        super(id, user, designation, description, frequency, frequencyValue, amount, startDate, endDate, status, createdAt, updatedAt, deletedAt);
    }
}
