package me.jinwenjie.service.impl;

import me.jinwenjie.model.User;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User get(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int create(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
