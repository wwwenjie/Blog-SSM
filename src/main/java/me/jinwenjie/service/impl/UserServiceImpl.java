package me.jinwenjie.service.impl;

import me.jinwenjie.dao.OptionDao;
import me.jinwenjie.dao.UserDao;
import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.errorhandle.ExceptionEnum;
import me.jinwenjie.model.OptionExample;
import me.jinwenjie.model.User;
import me.jinwenjie.model.UserExample;
import me.jinwenjie.service.UserService;
import me.jinwenjie.util.JWTUtil;
import org.apache.commons.lang.StringUtils;
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

    /**
     * @param user email password
     * @return token
     */
    public String login(User user) {
        // todo: encrypt
        if (StringUtils.isEmpty(user.getUserEmail()) || StringUtils.isEmpty(user.getUserPassword())) {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_EMPTY);
        }
        // UserExample 是 MBG 的查询类，用于实现复杂查询，若未使用 MBG，自行通过 dao 实现
        // 返回邮箱、密码匹配的用户 ID
        String email = user.getUserEmail();
        String password = user.getUserPassword();
        UserExample example = new UserExample();
        example.or().andUserEmailEqualTo(email).andUserPasswordEqualTo(password);
        List<User> resultList = userDao.selectByExample(example);
        if (resultList.isEmpty()) {
            throw new CustomException(ExceptionEnum.USER_ACCOUNT_WRONG);
        }
        Integer uid = resultList.get(0).getUserId();
        if (getAdminEmail().equals(email)) {
            return JWTUtil.sign(uid, true);
        } else {
            return JWTUtil.sign(uid);
        }
    }

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
        if (StringUtils.isEmpty(user.getUserEmail()) || StringUtils.isEmpty(user.getUserPassword())) {
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
