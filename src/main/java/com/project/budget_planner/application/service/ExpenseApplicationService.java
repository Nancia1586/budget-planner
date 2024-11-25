package com.project.budget_planner.application.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.budget_planner.application.dto.expense.CreateExpenseDto;
import com.project.budget_planner.application.dto.expense.ExpenseDto;
import com.project.budget_planner.application.dto.expense.UpdateExpenseDto;
import com.project.budget_planner.domain.model.Expense;
import com.project.budget_planner.domain.service.ExpenseService;

@Service
public class ExpenseApplicationService {
    private final ExpenseService expenseService;

    private ExpenseDto toExpenseDto(Expense expense) {
        return new ExpenseDto(
            expense.getId(),
            expense.getUser(),
            expense.getDesignation(),
            expense.getDescription(),
            expense.getFrequency(),
            expense.getFrequencyValue(),
            expense.getAmount(),
            expense.getStartDate(),
            expense.getEndDate(),
            expense.getStatus(),
            expense.getCreatedAt(),
            expense.getUpdatedAt(),
            expense.getDeletedAt()
        );
    }

    public ExpenseApplicationService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public ExpenseDto createExpense(CreateExpenseDto expenseDTO) {
        Expense expense = new Expense();
        expense.setUser(expenseDTO.getUser());
        expense.setDesignation(expenseDTO.getDesignation());
        expense.setDescription(expenseDTO.getDescription());
        expense.setFrequency(expenseDTO.getFrequency());
        expense.setFrequencyValue(expenseDTO.getFrequencyValue());
        expense.setAmount(expenseDTO.getAmount());
        expense.setStartDate(expenseDTO.getStartDate());
        expense.setEndDate(expenseDTO.getEndDate());

        Expense createdExpense = expenseService.createExpense(expense);
        return toExpenseDto(createdExpense);
    }

    public ExpenseDto updateExpense(Long expenseId, UpdateExpenseDto expenseDTO) {
        Expense expense = expenseService.getExpenseById(expenseId)
            .orElseThrow(() -> new NoSuchElementException("Expense not found"));

        expenseDTO.getUser().ifPresent(expense::setUser);
        expenseDTO.getDesignation().ifPresent(expense::setDesignation);
        expenseDTO.getDescription().ifPresent(expense::setDescription);
        expenseDTO.getFrequency().ifPresent(expense::setFrequency);
        expenseDTO.getFrequencyValue().ifPresent(expense::setFrequencyValue);
        expenseDTO.getAmount().ifPresent(expense::setAmount);
        expenseDTO.getStartDate().ifPresent(expense::setStartDate);
        expenseDTO.getEndDate().ifPresent(expense::setEndDate);

        Expense updatedExpense = expenseService.updateExpense(expense);
        return toExpenseDto(updatedExpense);
    }

    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses().stream()
            .map(this::toExpenseDto)
            .collect(Collectors.toList());
    }

    public Optional<ExpenseDto> getExpenseById(Long id) {
        return expenseService.getExpenseById(id)
            .map(this::toExpenseDto);
    }

    public void deleteExpense(Long id) {
        expenseService.deleteExpense(id);
    }
}
