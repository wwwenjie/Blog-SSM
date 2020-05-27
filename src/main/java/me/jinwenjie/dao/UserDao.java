package me.jinwenjie.dao;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}