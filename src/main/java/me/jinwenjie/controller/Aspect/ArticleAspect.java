package me.jinwenjie.controller.Aspect;

import me.jinwenjie.model.Article;
import me.jinwenjie.model.Log;
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
public class ArticleAspect {
    private final LogService logService;
    private final UserService userService;

    public ArticleAspect(UserService userService, LogService logService) {
        this.userService = userService;
        this.logService = logService;
    }

    @Pointcut("execution(* me.jinwenjie.controller.ArticleController.*Article(..))")
    public void articlePointCut() {
    }

    @Before("articlePointCut()")
    public void articleChange(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        token = token == null ? "" : token.split(" ")[1];
        Integer id = 0;
        if (joinPoint.getSignature().getName().equals("deleteArticle")) {
            id = (Integer) joinPoint.getArgs()[0];
        } else {
            Article article = (Article) joinPoint.getArgs()[0];
            id = article.getArticleId();
        }
        Log log = new Log();
        log.setAction(joinPoint.getSignature().getName());
        log.setUser(userService.get(JWTUtil.getUserId(token)).getUserName() + " 博文ID: " + id);
        log.setIp(request.getRemoteAddr());
        logService.addLog(log);
    }
}
