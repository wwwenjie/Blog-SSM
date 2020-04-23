package me.jinwenjie.service.impl;

import me.jinwenjie.model.User;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.model.UserExample;
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
    public Long login(String email, String password) {
        // todo: encrypt
        UserExample example = new UserExample();
        example.or().andUserEmailEqualTo(email).andUserPasswordEqualTo(password);
        List<User> resultList = userDao.selectByExample(example);
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0).getUserId();
        }
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        return userDao.selectByExample(example);
    }

    @Override
    public User get(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean create(User user) {
        return userDao.insert(user) == 1;
    }

    @Override
    public boolean update(User user) {
        return userDao.updateByPrimaryKeySelective(user) == 1;
    }

    @Override
    public boolean delete(Long id) {
        return userDao.deleteByPrimaryKey(id) == 1;
    }
}
