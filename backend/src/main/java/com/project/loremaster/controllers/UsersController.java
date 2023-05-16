package com.project.loremaster.controllers;

import com.project.loremaster.models.Users;
import com.project.loremaster.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/get")
    public Users getUsers(){
        return usersRepository.getReferenceById(1L);
    }

    record NewUserRequest(
            String login,
            String password,
            String username
    ){

    }

    @PostMapping("/add")
    public void addUser(@RequestBody NewUserRequest request){
        Users user = new Users();
        user.setUsername(request.username());
        user.setEmail(request.login());
        user.setPassword(request.password());
        usersRepository.save(user);
    }
}
