package com.manish.loanmanagement.repo;

import com.manish.loanmanagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo  extends JpaRepository<Loan, Long> {

}
