package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;
    private final UserService userService;

    public UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/register")
    public boolean register(@RequestParam String login,
                            @RequestParam String password,
                            @RequestParam String name,
                            @RequestParam String lastName){
      return userService.register(login, password, name, lastName);
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password) {
return userService.login(login, password);
    }
    @PostMapping
    public boolean editName( @RequestParam long id, @RequestParam String newName) {
        return userService.editName(id, newName);
    }
    @PostMapping
    public boolean editLastName( @RequestParam long id, @RequestParam String newLastName) {
        return userService.editLastName(id, newLastName);
    }
    @PostMapping
    public boolean editUrl( @RequestParam long id, @RequestParam String url) {
        return userService.editUrl(id, url);
    }
}
