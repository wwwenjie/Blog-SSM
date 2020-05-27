package me.jinwenjie.service.impl;

import com.alibaba.druid.util.StringUtils;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.model.User;
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
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean create(User user) {
        if (StringUtils.isEmpty(user.getUserEmail()) || StringUtils.isEmpty(user.getUserPassword())) {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_EMPTY);
        }
        return userDao.insert(user) == 1;
    }
}
