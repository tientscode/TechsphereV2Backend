package com.Techsphere.TechsphereV2Backend.Controller;

import com.Techsphere.TechsphereV2Backend.Repository.UserRepository;
import com.Techsphere.TechsphereV2Backend.Service.AuthService;
import com.Techsphere.TechsphereV2Backend.entity.User;
import com.Techsphere.TechsphereV2Backend.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TestController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Hello Admin");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> helloUser(){
        return ResponseEntity.ok("Hello User");
    }

    @PreAuthorize("hasRole('uni')")
    @GetMapping("/other")
    public ResponseEntity<String> helloOTHER(){
        return ResponseEntity.ok("Hello OTHER");
    }




    @PreAuthorize("hasRole('USER')")
    @GetMapping("/admin/user")
    public ResponseEntity<List<User>> getUsernameOrEmail() {
            List<User> user = userRepository.findAll();
            return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
