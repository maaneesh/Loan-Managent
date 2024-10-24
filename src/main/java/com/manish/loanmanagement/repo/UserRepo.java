package com.manish.loanmanagement.repo;

import com.manish.loanmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
