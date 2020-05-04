package me.jinwenjie.interceptor;

import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String token = request.getHeader("Authorization");
        if (method.equals("GET")) {
            return true;
        } else {
            if (token != null && JWTUtil.checkAdmin(token.split(" ")[1])) {
                return true;
            } else {
                throw new CustomException(ExceptionEnum.AUTH_NOT_ADMIN);
            }
        }
    }
}