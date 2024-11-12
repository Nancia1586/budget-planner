package com.project.budget_planner.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.project.budget_planner.domain.model.enums.ExpenseEnum.Frequency;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Status;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    
    @NotNull
    private String designation;

    private String description;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    private double frequencyValue;

    private double amount;
    
    @Nullable
    private LocalDate startDate;

    @Nullable
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    @Nullable
    private LocalDateTime updatedAt;

    @Nullable
    private LocalDateTime deletedAt;
    
    public Transaction() {}

    public Transaction(
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

    public User getUserId() {
        return this.user;
    }

    public void setUserId(User userId) {
        this.user = userId;
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
