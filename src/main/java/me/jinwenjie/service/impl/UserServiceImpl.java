package me.jinwenjie.service.impl;

import me.jinwenjie.dao.OptionDao;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
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
    public Integer getLoginUid(String email, Integer telephone, String password) {
        // todo: encrypt
        if (email == null && telephone == null || password == null) {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_EMPTY);
        } else {
            // UserExample 是 MBG 的查询类，用于实现复杂查询，若未使用 MBG，自行通过 dao 实现
            // 查询邮箱、手机、密码都匹配的用户 ID
            UserExample example = new UserExample();
            if (email == null) {
                example.or().andUserTelephoneNumberEqualTo(telephone).andUserPasswordEqualTo(password);
            } else {
                example.or().andUserEmailEqualTo(email).andUserPasswordEqualTo(password);
            }
            List<User> resultList = userDao.selectByExample(example);
            return resultList.isEmpty() ? null : resultList.get(0).getUserId();
        }
    }

    @Override
    public String getAdminEmail() {
        OptionExample example = new OptionExample();
        example.or().andOptionNameEqualTo("admin_email");
        // add blob to load blob(option_value)
        return optionDao.selectByExampleWithBLOBs(example).get(0).getOptionValue();
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
        // 空账号错误
        if (user.getUserEmail() == null && user.getUserTelephoneNumber() == null || user.getUserPassword() == null) {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_EMPTY);
        }
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
