package com.manish.loanmanagement.rest;

import com.manish.loanmanagement.entity.Loan;
import com.manish.loanmanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Method to check loan status by ID
    @GetMapping("/{id}/status")
    public ResponseEntity<String> checkLoanStatus(@PathVariable Long id) {
        try {
            Loan loan = loanService.findLoanById(id);
            return ResponseEntity.ok("Loan Status: " + loan.getStatus());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
