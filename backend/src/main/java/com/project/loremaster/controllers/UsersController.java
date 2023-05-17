package com.project.loremaster.controllers;

import com.project.loremaster.dto.RegisterDto;
import com.project.loremaster.entity.UsersEntity;
import com.project.loremaster.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/get")
    public ResponseEntity<UsersEntity> getUsers(@RequestParam("id") long id){
        Optional<UsersEntity> optional = usersRepository.findById(id);
        if(optional.isPresent()){
            UsersEntity output = optional.get();
            return ResponseEntity.status(HttpStatus.OK).body(output);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody RegisterDto registerDto){
        UsersEntity user = new UsersEntity();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getLogin());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        try {
            usersRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
