package me.jinwenjie.dao;

import me.jinwenjie.BaseTest;
import me.jinwenjie.model.OptionExample;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OptionDaoTest extends BaseTest {
    @Autowired
    OptionDao optionDao;

    @Test
    public void getAdminEmail() {
        OptionExample example = new OptionExample();
        example.or().andOptionNameEqualTo("admin_email");
        String email = optionDao.selectByExampleWithBLOBs(example).get(0).getOptionValue();
        Assert.assertEquals(email,"admin");
    }
}