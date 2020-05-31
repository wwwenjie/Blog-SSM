package me.jinwenjie.service.impl;

import me.jinwenjie.dao.AuthorityDao;
import me.jinwenjie.model.Authority;
import me.jinwenjie.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthorityDao authorityDao;

    public AuthServiceImpl(AuthorityDao authorityDao) {
        this.authorityDao = authorityDao;
    }

    @Override
    public boolean isAdmin(Integer uid) {
        List<Authority> auths = authorityDao.selectByUserId(uid);
        for (Authority auth : auths) {
            if (auth.getAuthId() == 1) {
                return true;
            }
        }
        return false;
    }
}
