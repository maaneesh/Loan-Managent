package com.manish.loanmanagement.service;



import com.manish.loanmanagement.entity.Loan;
import com.manish.loanmanagement.repo.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepo loanRepository;

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan findLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan with ID " + id + " not found"));
    }
}
