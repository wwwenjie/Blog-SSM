package me.jinwenjie.service;

import me.jinwenjie.BaseTest;
import me.jinwenjie.dao.ArticleDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceTest extends BaseTest {
    @Autowired
    ArticleDao articleDao;

    @Test
    public void findAll() {
        System.out.println(articleDao.findAll().get(0).getArticleCategory());
    }

    @Test
    public void getByCategory() {
        articleDao.getByCategory("未分类");
        Assert.assertEquals(articleDao.getByCategory("空分类").size(), 0);
    }

    @Test
    public void getByUserId() {
        articleDao.getByUserId(1);
        Assert.assertEquals(articleDao.getByUserId(555).size(), 0);
    }

    @Test
    public void count() {
        System.out.println(articleDao.count());
    }

    @Test
    public void get() {
        articleDao.selectByPrimaryKey(1);
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}