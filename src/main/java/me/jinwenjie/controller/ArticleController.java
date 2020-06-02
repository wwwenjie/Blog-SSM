package me.jinwenjie.controller;

import com.github.pagehelper.PageHelper;
import me.jinwenjie.model.Article;
import me.jinwenjie.service.ArticleService;
import me.jinwenjie.util.JSONResult;
import me.jinwenjie.util.JWTUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/articles")
@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    List<Article> getArticles(String articleCategory, Integer userId, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        if (articleCategory != null) {
            return articleService.getByCategory(articleCategory);
        }
        if (userId != null) {
            return articleService.getByUserId(userId);
        }
        return articleService.findAll();
    }

    @GetMapping("/total")
    public Integer count() {
        return articleService.count();
    }

    @GetMapping("/{id}")
    public Article findByPath(@PathVariable("id") Integer id) {
        return articleService.get(id);
    }

    @PostMapping("")
    public JSONObject createArticle(@RequestBody Article article, HttpServletRequest request) {
        if (article.getUserId() == null) {
            String token = request.getHeader("Authorization").split(" ")[1];
            article.setUserId(JWTUtil.getUserId(token));
        }
        articleService.create(article);
        return JSONResult.success();
    }

    @DeleteMapping("")
    public JSONObject deleteArticle(Integer articleId) {
        articleService.delete(articleId);
        return JSONResult.success();
    }

    @PatchMapping("")
    public JSONObject updateArticle(@RequestBody Article article) {
        articleService.update(article);
        return JSONResult.success();
    }
}
