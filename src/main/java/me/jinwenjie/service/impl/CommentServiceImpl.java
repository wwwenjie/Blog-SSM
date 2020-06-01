package me.jinwenjie.service.impl;

import me.jinwenjie.dao.CommentDao;
import me.jinwenjie.model.Comment;
import me.jinwenjie.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public List<Comment> getByArticleId(Integer id) {
        return commentDao.getByArticleId(id);
    }

    @Override
    public Integer count() {
        return commentDao.count();
    }

    @Override
    public List<Comment> getByUserId(Integer id) {
        return commentDao.getByUserId(id);
    }

    @Override
    public void create(Comment comment) {
        commentDao.insertSelective(comment);
    }

    @Override
    public void update(Comment comment) {
        commentDao.updateByPrimaryKeySelective(comment);
    }

    @Override
    public void delete(Integer id) {
        commentDao.deleteByPrimaryKey(id);
    }
}
