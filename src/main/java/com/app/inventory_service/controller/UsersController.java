package com.app.inventory_service.controller;

import com.app.inventory_service.model.Users;
import com.app.inventory_service.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/inventory")
public class UsersController {

    @Autowired
    private UsersService service;

    //To register a new user
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        System.out.println("controller");
        return service.register(user);
    }
    //To login through exsisting user
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
}
