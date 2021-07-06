package com.example.letscookit.users.presentation;

import com.example.letscookit.users.business.User;
import com.example.letscookit.users.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public void register(@Valid @RequestBody User user) {
        this.userService.register(user);
    }

}