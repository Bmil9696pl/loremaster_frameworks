package com.example.loremaster;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoremasterController {

    @RequestMapping(value = "/")
    public String helloWorld(){
        return "Hello there!";
    }

    @RequestMapping(value = "/goodbye")
    public String goodbyeWorld(){
        return "Goodbye!";
    }
}
