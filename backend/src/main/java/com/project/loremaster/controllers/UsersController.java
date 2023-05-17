package com.project.loremaster.controllers;

import com.project.loremaster.entity.UsersEntity;
import com.project.loremaster.models.Users;
import com.project.loremaster.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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

    record NewUserRequest(
            String login,
            String password,
            String username
    ){

    }

    @PostMapping("/add")
    public void addUser(@RequestParam("username") String username, @RequestParam("login") String login, @RequestParam("password") String password){
        UsersEntity user = new UsersEntity();
        user.setUsername(username);
        user.setEmail(login);
        user.setPassword(password);
        usersRepository.save(user);
    }
}
