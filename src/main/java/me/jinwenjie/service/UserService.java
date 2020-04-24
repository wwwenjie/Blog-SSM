package me.jinwenjie.service;

import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    Integer getLoginUid(String email, String password);

    String getAdminEmail();

    List<User> list();

    User get(Integer id);

    boolean create(User user);

    boolean update(User user);

    boolean delete(Integer id);
}
