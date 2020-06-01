package me.jinwenjie.service;

import me.jinwenjie.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> getByArticleId(Integer uid);

    List<Comment> getByUserId(Integer uid);

    Integer count();

    void create(Comment comment);

    void update(Comment comment);

    void delete(Integer id);
}
