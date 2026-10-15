package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.JWTService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword(), user.getId(),user.getRole());
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        String token = jwtService.generateToken(username);

        return ResponseEntity.ok(token);
    }


    @PostMapping("/products/{userId}")
    public ResponseEntity<?> addProduct(@PathVariable String userId, @RequestBody Map<String,String> data){

        Integer productId=Integer.valueOf(data.get("productId"));
        Integer quantity=Integer.valueOf(data.get("quantity"));

        return userService.addProduct(Integer.parseInt(userId),productId,quantity);



    }








}
