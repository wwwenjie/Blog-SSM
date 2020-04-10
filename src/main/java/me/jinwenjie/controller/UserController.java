package me.jinwenjie.controller;

import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.get(id);
    }
}
