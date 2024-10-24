package com.manish.loanmanagement.rest;

import com.manish.loanmanagement.entity.Loan;
import com.manish.loanmanagement.entity.User;
import com.manish.loanmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
         User  newUser = userService.register(user);
         return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/{id}/loans")
    public ResponseEntity<String> addLoan(@PathVariable Long id, @RequestBody Loan loan){
        userService.addLoanForUser(id, loan);
        return ResponseEntity.ok("Successfully added loan");

    }

}
