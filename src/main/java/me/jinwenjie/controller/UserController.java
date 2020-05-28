package me.jinwenjie.controller;

import com.github.pagehelper.PageHelper;
import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JSONResult;
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

    @GetMapping("/users")
    public List<User> getAllUser(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return userService.findAll();
    }

    @GetMapping("/users/total")
    public Integer getAllUser() {
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
