package me.jinwenjie.dao;

import me.jinwenjie.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> findAll();

    List<Comment> getByArticleId(Integer articleId);

    List<Comment> getByUserId(Integer userId);

    int count();

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}