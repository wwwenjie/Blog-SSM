package me.jinwenjie.controller;

import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JSONResult;
import me.jinwenjie.util.JWTUtil;
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
        Integer uid = userService.getLoginUid(user.getUserEmail(), user.getUserPassword());
        if (uid != null) {
            if (userService.getAdminEmail().equals(user.getUserEmail())) {
                return JSONResult.singleResult("token", JWTUtil.sign(uid, true));
            } else {
                return JSONResult.singleResult("token", JWTUtil.sign(uid));
            }
        } else {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_WRONG);
        }
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
    public JSONObject creatUser(@RequestBody User user, HttpServletRequest request) {
        user.setUserRegistrationDate(new Date());
        user.setUserIp(request.getRemoteAddr());
        userService.create(user);
        return JSONResult.success();
    }

    @PutMapping("/users/{id}")
    public JSONObject updateUserById(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setUserId(id);
        userService.update(user);
        return JSONResult.success();
    }

    @DeleteMapping("/users/{id}")
    public JSONObject deleteUserById(@PathVariable("id") Integer id) {
        userService.delete(id);
        return JSONResult.success();
    }
}
