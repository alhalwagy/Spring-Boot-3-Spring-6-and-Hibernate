package com.demo.springboot.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // "/" return  hello world

    @GetMapping("/")
    public String  sayHello(){
        return "Hello World!";
    }
}
