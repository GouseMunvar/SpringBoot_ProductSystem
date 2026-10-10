
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bcrypt;

    public UserService(UserRepo userRepo,
                       BCryptPasswordEncoder bcrypt) {
        this.userRepo = userRepo;
        this.bcrypt = bcrypt;
    }

    public ResponseEntity<String> registerUser(
            String username, String password, int id) {

        String encodedPassword = bcrypt.encode(password);

        User user = new User(id, username, encodedPassword);
        userRepo.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<String> loginUser(
            String username, String password) {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid username or password");
        }

        boolean isValid = bcrypt.matches(
                password, user.getPassword());

        if (!isValid) {
            return ResponseEntity.badRequest()
                    .body("Invalid username or password");
        }

        return ResponseEntity.ok("Login successful");
    }
}