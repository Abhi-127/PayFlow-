package org.airtribe.PayFlow.controller;




import org.airtribe.PayFlow.entity.User;
import org.airtribe.PayFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST /users - Register a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Received User: " + user);
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // GET /users/{id} - Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /users - Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // GET /users/upi/{upiId} - Get user by UPI ID
    @GetMapping("/upi/{upiId}")
    public ResponseEntity<User> getUserByUpiId(@PathVariable String upiId) {
        Optional<User> user = userService.findByUpiId(upiId);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}