package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    boolean create(User user);
}
