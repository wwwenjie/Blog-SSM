package me.jinwenjie.controller;

import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JsonResult;
import me.jinwenjie.util.JwtUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/tokens")
    public JSONObject login(@RequestBody User user) {
        Long uid = userService.login(user.getUserEmail(), user.getUserPassword());
        if (uid != null) {
            return JsonResult.singleResult("token", JwtUtil.sign(uid));
        } else {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_WRONG);
        }
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
    public JSONObject creatUser(@RequestBody User user, HttpServletRequest request) {
        user.setUserRegistrationDate(new Date());
        user.setUserIp(request.getRemoteAddr());
        userService.create(user);
        return JsonResult.success();
    }

    @PutMapping("/users/{id}")
    public JSONObject updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        user.setUserId(id);
        userService.update(user);
        return JsonResult.success();
    }

    @DeleteMapping("/users/{id}")
    public JSONObject deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return JsonResult.success();
    }
}
