package me.jinwenjie.dao;

import me.jinwenjie.model.ArticleLabelKey;

public interface ArticleLabelDao {
    int deleteByPrimaryKey(ArticleLabelKey key);

    int insert(ArticleLabelKey record);

    int insertSelective(ArticleLabelKey record);
}