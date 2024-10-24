package com.manish.loanmanagement.service;

import com.manish.loanmanagement.entity.Loan;
import com.manish.loanmanagement.entity.User;
import com.manish.loanmanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User register(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public void addLoanForUser(Long userId, Loan loan) {
        User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User with id " + userId + " not found"));

        loan.setUser(user);
        user.getLoans().add(loan);
        userRepo.save(user);

    }



}
