package me.jinwenjie.service;

import me.jinwenjie.dao.UserDao;
import me.jinwenjie.model.User;
import me.jinwenjie.model.UserExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> list() {
        UserExample example = new UserExample();
        return userDao.selectByExample(example);
    }

    public User get(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    public boolean create(User user) {
        return userDao.insert(user) == 1;
    }

    public boolean update(User user) {
        return userDao.updateByPrimaryKeySelective(user) == 1;
    }

    public boolean delete(Long id) {
        return userDao.deleteByPrimaryKey(id) == 1;
    }
}
