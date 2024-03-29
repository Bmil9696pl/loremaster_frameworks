package com.project.loremaster.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoremasterController {

    @RequestMapping(value = "/")
    public String helloWorld(){
        return "Hello there!";
    }

    @RequestMapping(value = "/goodbye")
    public String goodbyeWorld(){
        return "Goodbye!";
    }

    @RequestMapping("api/messages")
    public String getMessage(){
        return "message sent";
    }
}
