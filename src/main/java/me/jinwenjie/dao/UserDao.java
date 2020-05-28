package me.jinwenjie.dao;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    int count();

    void deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User record);
}