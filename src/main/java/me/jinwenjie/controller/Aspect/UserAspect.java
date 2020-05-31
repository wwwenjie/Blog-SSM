package me.jinwenjie.controller.Aspect;

import me.jinwenjie.model.User;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JWTUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class UserAspect {

    private final UserService userService;
    private static final Logger log = Logger.getLogger("UserLog");

    public UserAspect(UserService userService) {
        this.userService = userService;
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
        log.info("方法名：" + joinPoint.getSignature().getName());
        log.info("用户名：" + userService.get(JWTUtil.getUserId(token)).getUserName());
        log.info("IP：" + request.getRemoteAddr());
        log.info("时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Before("loginPointCut()")
    public void login(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        User user = (User) joinPoint.getArgs()[0];
        log.info("方法名：" + joinPoint.getSignature().getName());
        log.info("用户邮箱：" + user.getUserEmail());
        log.info("用户密码：" + user.getUserEmail());
        log.info("IP：" + request.getRemoteAddr());
        log.info("时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}