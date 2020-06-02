package me.jinwenjie.controller.Aspect;

import me.jinwenjie.model.Log;
import me.jinwenjie.model.User;
import me.jinwenjie.service.LogService;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JWTUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class UserAspect {
    private final LogService logService;
    private final UserService userService;

    public UserAspect(UserService userService, LogService logService) {
        this.userService = userService;
        this.logService = logService;
    }

    // 用户切点
    @Pointcut("execution(* me.jinwenjie.controller.UserController.*User(..))")
    public void userPointCut() {
    }

    // 登陆切点
    @Pointcut("execution(* me.jinwenjie.controller.UserController.login(..))")
    public void loginPointCut() {
    }

    // 管理员操作
    @Before("userPointCut()")
    public void adminLog(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        token = token == null ? "" : token.split(" ")[1];
        Log log = new Log();
        log.setAction(joinPoint.getSignature().getName());
        log.setUser("用户名: " + userService.get(JWTUtil.getUserId(token)).getUserName());
        log.setIp(request.getRemoteAddr());
        logService.addLog(log);
    }

    @Before("loginPointCut()")
    public void login(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        User user = (User) joinPoint.getArgs()[0];
        Log log = new Log();
        log.setAction(joinPoint.getSignature().getName());
        log.setUser("用户邮箱: " + user.getUserEmail() + ", 用户密码: " + user.getUserEmail());
        log.setIp(request.getRemoteAddr());
        logService.addLog(log);
    }
}