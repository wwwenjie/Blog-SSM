package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User get(Integer id);

    int create(User user);

    int update(User user);

    int delete(Integer id);
}
