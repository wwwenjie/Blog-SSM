package me.jinwenjie.service.impl;

import me.jinwenjie.dao.ArticleDao;
import me.jinwenjie.model.Article;
import me.jinwenjie.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> getByCategory(String category) {
        return articleDao.getByCategory(category);
    }

    @Override
    public List<Article> getByUserId(Integer uid) {
        return articleDao.getByUserId(uid);
    }

    @Override
    public Integer count() {
        return articleDao.count();
    }

    @Override
    public Article get(Integer id) {
        return articleDao.selectByPrimaryKey(id);
    }

    @Override
    public void create(Article article) {
        articleDao.insertSelective(article);
    }

    @Override
    public void update(Article article) {
        articleDao.updateByPrimaryKeyWithBLOBs(article);
    }

    @Override
    public void delete(Integer id) {
        articleDao.deleteByPrimaryKey(id);
    }
}
