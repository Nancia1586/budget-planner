package com.project.budget_planner.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.budget_planner.application.dto.expense.CreateExpenseDto;
import com.project.budget_planner.application.dto.expense.ExpenseDto;
import com.project.budget_planner.application.dto.expense.UpdateExpenseDto;
import com.project.budget_planner.application.service.ExpenseApplicationService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseApplicationService expenseApplicationService;

    public ExpenseController(ExpenseApplicationService expenseApplicationService) {
        this.expenseApplicationService = expenseApplicationService;
    }

    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseApplicationService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Optional<ExpenseDto> getExpenseById(@PathVariable Long id) {
        return expenseApplicationService.getExpenseById(id);
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createUser(@RequestBody CreateExpenseDto expenseDto) {
        ExpenseDto registeredExpense = expenseApplicationService.createExpense(expenseDto);
        return ResponseEntity.ok(registeredExpense);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpenseDto> createUser(
        @PathVariable Long id,
        @RequestBody UpdateExpenseDto updateExpenseDto
    ) {
        ExpenseDto updatedExpense = expenseApplicationService.updateExpense(id, updateExpenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseApplicationService.deleteExpense(id);
    }
}
