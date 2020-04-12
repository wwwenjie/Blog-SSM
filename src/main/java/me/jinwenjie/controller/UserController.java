package me.jinwenjie.controller;

import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("/users")
    public Map<String, Object> creatUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.create(user);
            map.put("success", true);
        } catch (Exception e) {
            map.put("error", "fail to create uesr: " + user.getName() + ", error: " + e.getMessage());
            map.put("code", 501);
        }
        return map;
    }

    @PutMapping("/users/{id}")
    public Map<String, Object> updateUserById(@PathVariable("id") Integer id, @RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            user.setId(id);
            userService.update(user);
            map.put("success", true);
        } catch (Exception e) {
            map.put("error", "fail to update user: " + user.getName() + ", error: " + e.getMessage());
            map.put("code", 501);
        }
        return map;
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Object> deleteUserById(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            map.put("error", "fail to delete uid: " + id + ", error: " + e.getMessage());
            map.put("code", 501);
        }
        return map;
    }
}