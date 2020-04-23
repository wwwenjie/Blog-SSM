package me.jinwenjie.controller;

import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JwtUtil;
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

    @PostMapping("/tokens")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        Long uid = userService.login(user.getUserEmail(), user.getUserPassword());
        if (uid != null) {
            map.put("success", true);
            map.put("token", JwtUtil.sign(uid));
        } else {
            map.put("error", "email or password wrong");
            map.put("code", 403);
        }
        return map;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PostMapping("/users")
    public Map<String, Object> creatUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        // todo: throw sql error to interceptor
        try {
            if (userService.create(user)) {
                map.put("success", true);
            } else {
                map.put("error", "fail to create user: database return 0 ");
                map.put("code", 500);
            }
        } catch (Exception e) {
            map.put("error", "fail to create user: " + user.getUserName() + ", error: " + e.getMessage());
            map.put("code", 500);
        }
        return map;
    }

    @PutMapping("/users/{id}")
    public Map<String, Object> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            user.setUserId(id);
            userService.update(user);
            map.put("success", true);
        } catch (Exception e) {
            map.put("error", "fail to update user: " + user.getUserName() + ", error: " + e.getMessage());
            map.put("code", 500);
        }
        return map;
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Object> deleteUserById(@PathVariable("id") Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            map.put("error", "fail to delete uid: " + id + ", error: " + e.getMessage());
            map.put("code", 500);
        }
        return map;
    }
}
