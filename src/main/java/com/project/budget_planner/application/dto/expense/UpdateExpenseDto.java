package com.project.budget_planner.application.dto.expense;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Frequency;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Status;

public class UpdateExpenseDto {
    private Optional<User> user = Optional.empty();
    private Optional<String> designation = Optional.empty();
    private Optional<String> description = Optional.empty();
    private Optional<Frequency> frequency = Optional.empty();
    private Optional<Double> frequencyValue = Optional.empty();
    private Optional<Double> amount = Optional.empty();
    private Optional<LocalDate> startDate = Optional.empty();
    private Optional<LocalDate> endDate = Optional.empty();
    private Optional<Status> status = Optional.empty();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public UpdateExpenseDto() {}

    public UpdateExpenseDto(
        Optional<User> user,
        Optional<String> designation,
        Optional<String> description,
        Optional<Frequency> frequency,
        Optional<Double> frequencyValue,
        Optional<Double> amount,
        Optional<LocalDate> startDate,
        Optional<LocalDate> endDate
    ) {
        this.user = user;
        this.designation = designation;
        this.description = description;
        this.frequency = frequency;
        this.frequencyValue = frequencyValue;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Optional<User> getUser() {
        return this.user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }

    public Optional<String> getDesignation() {
        return this.designation;
    }

    public void setDesignation(Optional<String> Designation) {
        this.designation = Designation;
    }

    public Optional<String> getDescription() {
        return this.description;
    }

    public void setDescription(Optional<String> Description) {
        this.description = Description;
    }

    public Optional<Frequency> getFrequency() {
        return this.frequency;
    }

    public void setFrequency(Optional<Frequency> frequency) {
        this.frequency = frequency;
    }

    public Optional<Double> getFrequencyValue() {
        return this.frequencyValue;
    }

    public void setFrequencyValue(Optional<Double> frequencyValue) {
        this.frequencyValue = frequencyValue;
    }

    public Optional<Double> getAmount() {
        return this.amount;
    }

    public void setAmount(Optional<Double> amount) {
        this.amount = amount;
    }

    public Optional<LocalDate> getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Optional<LocalDate> startDate) {
        this.startDate = startDate;
    }

    public Optional<LocalDate> getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Optional<LocalDate> endDate) {
        this.endDate = endDate;
    }

    public Optional<Status> getStatus() {
        return this.status;
    }

    public void setStatus(Optional<Status> status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
