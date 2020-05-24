package me.jinwenjie.service;

import me.jinwenjie.model.Address;
import me.jinwenjie.model.User;

import java.util.List;

public interface UserService {
    String login(User user);

    List<User> list();

    User get(Integer id);

    boolean create(User user);

    boolean update(User user);

    boolean delete(Integer id);

    boolean addAddress(Address address);
}
