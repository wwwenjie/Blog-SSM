package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User get(Long id);

    boolean create(User user);

    boolean update(User user);

    boolean delete(Long id);
}
