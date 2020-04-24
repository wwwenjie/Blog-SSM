package me.jinwenjie.service;

import me.jinwenjie.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class UserServiceTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void getAdminEmail() {
        assertEquals("admin", userService.getAdminEmail());
    }
}