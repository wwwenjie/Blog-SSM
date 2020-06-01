package me.jinwenjie.controller;

import com.github.pagehelper.PageHelper;
import me.jinwenjie.model.Comment;
import me.jinwenjie.service.CommentService;
import me.jinwenjie.util.JSONResult;
import me.jinwenjie.util.JWTUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/comments")
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    List<Comment> getArticles(Integer articleId, Integer userId, Integer pageNum, Integer pageSize) {
        if (articleId != null) {
            return commentService.getByArticleId(articleId);
        }
        if (userId != null) {
            return commentService.getByUserId(userId);
        }
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return commentService.findAll();
    }

    @GetMapping("/total")
    public Integer total() {
        return commentService.count();
    }

    @PostMapping("")
    public JSONObject create(@RequestBody Comment comment, HttpServletRequest request) {
        if (comment.getUserId() == null && request.getHeader("Authorization") != null) {
            String token = request.getHeader("Authorization").split(" ")[1];
            comment.setUserId(JWTUtil.getUserId(token));
        }
        comment.setUserIp(request.getRemoteAddr());
        commentService.create(comment);
        return JSONResult.success();
    }

    @DeleteMapping("")
    public JSONObject delete(Integer commentId) {
        commentService.delete(commentId);
        return JSONResult.success();
    }

    @PatchMapping("")
    public JSONObject update(@RequestBody Comment comment) {
        commentService.update(comment);
        return JSONResult.success();
    }
}
