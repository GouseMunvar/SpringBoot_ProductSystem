
package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bcrypt;
    private final ProductRepo productRepo;

    public UserService(UserRepo userRepo,
                       BCryptPasswordEncoder bcrypt,ProductRepo productRepo) {
        this.userRepo = userRepo;
        this.bcrypt = bcrypt;
        this.productRepo=productRepo;
    }

    public ResponseEntity<String> registerUser(
            String username, String password, int id,String role) {

        String encodedPassword = bcrypt.encode(password);

        User user = new User(id, username, encodedPassword,role,null);
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


    public ResponseEntity<?> addProduct(int userid, int productId, int quantity) {

        User user = userRepo.getReferenceById(userid);

        Optional<Product> optionalProduct = productRepo.findById(productId);

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().body("Product not found");
        }

        Product product = optionalProduct.get();

        product.setQuantity(quantity);

        product.setUser(user);

        productRepo.save(product);

        return ResponseEntity.ok("Product is added");
    }



}