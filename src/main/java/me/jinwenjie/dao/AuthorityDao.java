package me.jinwenjie.dao;

import me.jinwenjie.model.Authority;

import java.util.List;

public interface AuthorityDao {
    List<Authority> selectByUserId(Integer uid);
}