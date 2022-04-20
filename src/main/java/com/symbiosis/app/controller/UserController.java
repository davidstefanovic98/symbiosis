package com.symbiosis.app.controller;

import com.symbiosis.app.entity.User;
import com.symbiosis.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(User user) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.save(user));
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}
