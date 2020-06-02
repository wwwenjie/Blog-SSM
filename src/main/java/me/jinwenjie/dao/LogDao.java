package me.jinwenjie.dao;

import me.jinwenjie.model.Log;

import java.util.List;

public interface LogDao {
    Integer count();

    List<Log> findAll();

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);
}