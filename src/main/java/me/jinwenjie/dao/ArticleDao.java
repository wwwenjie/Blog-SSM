package me.jinwenjie.dao;

import me.jinwenjie.model.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> findAll();

    List<Article> getByCategory(String category);

    List<Article> getByUserId(Integer uid);

    int count();

    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}