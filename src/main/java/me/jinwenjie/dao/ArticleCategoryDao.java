package me.jinwenjie.dao;

import me.jinwenjie.model.ArticleCategoryKey;

public interface ArticleCategoryDao {
    int deleteByPrimaryKey(ArticleCategoryKey key);

    int insert(ArticleCategoryKey record);

    int insertSelective(ArticleCategoryKey record);
}