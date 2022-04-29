package com.symbiosis.app.controller;

import com.symbiosis.app.entity.User;
import com.symbiosis.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) Specification<User> specification,
                                                  @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(userService.findAll(specification, sort));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(User user) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.save(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}
