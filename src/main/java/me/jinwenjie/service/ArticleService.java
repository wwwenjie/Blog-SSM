package me.jinwenjie.service;

import me.jinwenjie.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    List<Article> getByCategory(String category);

    List<Article> getByUserId(Integer uid);

    Integer count();

    Article get(Integer id);

    void create(Article article);

    void update(Article article);

    void delete(Integer id);
}
