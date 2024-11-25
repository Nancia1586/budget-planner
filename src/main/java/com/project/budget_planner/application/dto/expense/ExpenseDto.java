package com.project.budget_planner.application.dto.expense;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Frequency;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Status;

public class ExpenseDto {
    private Long id;
    private User user;
    private String designation;
    private String description;
    private Frequency frequency;
    private double frequencyValue;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public ExpenseDto() {}

    public ExpenseDto(
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
        this.id = id;
        this.user = user;
        this.designation = designation;
        this.description = description;
        this.frequency = frequency;
        this.frequencyValue = frequencyValue;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String Designation) {
        this.designation = Designation;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public Frequency getFrequency() {
        return this.frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public double getFrequencyValue() {
        return this.frequencyValue;
    }

    public void setFrequencyValue(double frequencyValue) {
        this.frequencyValue = frequencyValue;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}