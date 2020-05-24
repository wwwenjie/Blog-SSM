package me.jinwenjie.controller;

import me.jinwenjie.model.Address;
import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JSONResult;
import me.jinwenjie.util.JWTUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

// RESTful 风格接口设计，接受返回 json 数据
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user email password
     * @return token uid
     */
    @PostMapping("/tokens")
    public JSONObject login(@RequestBody User user) {
        String token = userService.login(user);
        Integer uid = JWTUtil.getUserId(token);
        JSONObject res = new JSONObject();
        res.put("token", token);
        res.put("uid", uid);
        return res;
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
        // 设置注册时间，IP
        user.setUserRegistrationDate(new Date());
        user.setUserIp(request.getRemoteAddr());
        userService.create(user);
        JSONObject res = this.login(user);
        return JSONResult.singleResult("uid", res.get("uid"));
    }

    @PostMapping("/address")
    public JSONObject addAddress(@RequestBody Address address) {
        userService.addAddress(address);
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

    @PostMapping("/images")
    public JSONObject fileUpload(@RequestParam("img") MultipartFile file, HttpServletRequest request) throws IOException {
        // windows 系统路径 \\
        String filePath = request.getSession().getServletContext().getRealPath("\\") + "\\img\\" + file.getOriginalFilename();
        System.out.println(filePath);
        file.transferTo(new File(filePath));
        return JSONResult.singleResult("url", "/img/" + file.getOriginalFilename());
    }
}
