package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Integer count();

    void create(User user);

    void update(User user);

    void delete(Integer id);
}
