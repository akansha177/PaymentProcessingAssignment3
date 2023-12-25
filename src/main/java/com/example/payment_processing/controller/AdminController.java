package com.example.payment_processing.controller;
import com.example.payment_processing.entity.Admin;
import com.example.payment_processing.entity.User;
import com.example.payment_processing.exceptions.UserAlreadyApprovedException;
import com.example.payment_processing.exceptions.UserNotFoundException;
import com.example.payment_processing.repository.AdminRepository;
import com.example.payment_processing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        if (adminRepository.existsById(admin.getAdminId())) {
            return ResponseEntity.badRequest().body("Admin with the same name already exists.");
        }
        adminRepository.save(admin);

        return ResponseEntity.ok("Admin registration successful.");
    }


    @PostMapping("/approve/{user_id}")
    public ResponseEntity<String> approveUser(@PathVariable int user_id) {
        try {
            User approvedUser = userService.approveUser(user_id);
            return ResponseEntity.ok("User with ID " + approvedUser.getUser_id() + " has been approved.");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (UserAlreadyApprovedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already approved");
        }
    }
}