package me.jinwenjie.service.impl;

import me.jinwenjie.dao.OptionDao;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.model.OptionExample;
import me.jinwenjie.model.User;
import me.jinwenjie.model.UserExample;
import me.jinwenjie.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final OptionDao optionDao;

    public UserServiceImpl(UserDao userDao, OptionDao optionDao) {
        this.userDao = userDao;
        this.optionDao = optionDao;
    }

    @Override
    public Integer getLoginUid(String email, String password) {
        // todo: encrypt
        UserExample example = new UserExample();
        example.or().andUserEmailEqualTo(email).andUserPasswordEqualTo(password);
        List<User> resultList = userDao.selectByExample(example);
        return resultList.isEmpty() ? null : resultList.get(0).getUserId();
    }

    @Override
    public String getAdminEmail() {
        OptionExample example = new OptionExample();
        example.or().andOptionNameEqualTo("admin_email");
        return optionDao.selectByExample(example).get(0).getOptionValue();
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        return userDao.selectByExample(example);
    }

    @Override
    public User get(Integer id) {
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
    public boolean delete(Integer id) {
        return userDao.deleteByPrimaryKey(id) == 1;
    }
}
