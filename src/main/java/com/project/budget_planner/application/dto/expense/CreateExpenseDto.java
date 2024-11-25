package com.project.budget_planner.application.dto.expense;

import java.time.LocalDate;
import com.project.budget_planner.domain.model.User;
import com.project.budget_planner.domain.model.enums.ExpenseEnum.Frequency;

public class CreateExpenseDto {
    private User user;
    private String designation;
    private String description;
    private Frequency frequency;
    private double frequencyValue;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public CreateExpenseDto() {}

    public CreateExpenseDto(
        User user,
        String designation,
        String description,
        Frequency frequency,
        double frequencyValue,
        double amount,
        LocalDate startDate,
        LocalDate endDate
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
}
