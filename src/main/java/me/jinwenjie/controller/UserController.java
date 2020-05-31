package me.jinwenjie.controller;

import com.github.pagehelper.PageHelper;
import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.model.User;
import me.jinwenjie.service.AuthService;
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
    private final AuthService authService;
    private final UserService userService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/tokens")
    public JSONObject login(@RequestBody User user) {
        Integer uid = userService.getLoginUid(user.getUserEmail(), user.getUserPassword());
        if (uid != null) {
            if (authService.isAdmin(uid)) {
                return JSONResult.singleResult("token", JWTUtil.sign(uid, true));
            } else {
                return JSONResult.singleResult("token", JWTUtil.sign(uid));
            }
        } else {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_WRONG);
        }
    }

    @GetMapping("/users")
    public List<User> getAllUser(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return userService.findAll();
    }

    @GetMapping("/users/total")
    public Integer countTotalUser() {
        return userService.count();
    }

    @PostMapping("/users")
    public JSONObject creatUser(@RequestBody User user, HttpServletRequest request) {
        // 设置注册时间，IP
        user.setUserRegistrationDate(new Date());
        user.setUserIp(request.getRemoteAddr());
        userService.create(user);
        return JSONResult.success();
    }

    @PatchMapping("/users")
    public JSONObject updateUser(@RequestBody User user) {
        userService.update(user);
        return JSONResult.success();
    }

    @DeleteMapping("/users/{id}")
    public JSONObject deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return JSONResult.success();
    }

}
