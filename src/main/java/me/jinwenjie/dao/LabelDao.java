package me.jinwenjie.dao;

import me.jinwenjie.model.Label;

public interface LabelDao {
    int deleteByPrimaryKey(Long labelId);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Long labelId);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}