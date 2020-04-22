package me.jinwenjie.interceptor;

import me.jinwenjie.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        // Bearer xxx
        String token = request.getHeader("Authorization");
        token = token == null ? "" : token.split(" ")[1];
        // URI: /users
        if (request.getRequestURI().equals("/users")) {
            switch (method) {
                // admin
                case "GET":
                    return JwtUtil.checkAdmin(token);
                // everyone
                case "POST":
                    return true;
                // refuse others
                default:
                    return false;
            }
        }
        // URI: /users/uid
        Integer uid = Integer.parseInt(request.getRequestURI().split("/")[2]);
        switch (method) {
            // user self or admin
            case "GET":
            case "PUT":
                return JwtUtil.getUserId(token).equals(uid) || JwtUtil.checkAdmin(token);
            // admin
            case "DELETED":
                return JwtUtil.checkAdmin(token);
            // refuse others
            default:
                return false;
        }
    }
}
