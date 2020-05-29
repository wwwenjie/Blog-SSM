package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Integer count();

    User get(Integer id);

    void create(User user);

    void update(User user);

    void delete(Integer id);

    Integer getLoginUid(String email, String password);
}
