package me.jinwenjie.interceptor;

import me.jinwenjie.util.JwtUtil;
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
            return token != null && JwtUtil.checkAdmin(token.split(" ")[1]);
        }
    }
}