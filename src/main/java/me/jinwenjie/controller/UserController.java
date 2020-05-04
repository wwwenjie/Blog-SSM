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

// RESTful 风格接口设计，接受返回 json 数据
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 登陆
    @PostMapping("/tokens")
    public JSONObject login(@RequestBody User user) {
        // 根据邮箱、手机、密码判断用户是否存在（邮箱手机二选一即可，没有为空）
        Integer uid = userService.getLoginUid(user.getUserEmail(), user.getUserTelephoneNumber(), user.getUserPassword());
        if (uid != null) {
            // 根据 option 表里的管理员邮箱判断是否是管理员
            if (userService.getAdminEmail().equals(user.getUserEmail())) {
                // 下发 JWT Token
                return JSONResult.singleResult("token", JWTUtil.sign(uid, true));
            } else {
                return JSONResult.singleResult("token", JWTUtil.sign(uid));
            }
        } else {
            // 抛出账号密码错误
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

    // 注册
    @PostMapping("/users")
    public JSONObject creatUser(@RequestBody User user, HttpServletRequest request) {
        // 设置注册时间，IP，用户名（若为空）
        user.setUserRegistrationDate(new Date());
        user.setUserIp(request.getRemoteAddr());
        if (user.getUserName() == null) {
            user.setUserName("Default User Name");
        }
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
