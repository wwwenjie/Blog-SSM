package me.jinwenjie.service;

import me.jinwenjie.BaseTest;
import me.jinwenjie.errorhandle.CustomException;
import me.jinwenjie.model.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;


public class UserServiceTest extends BaseTest {
    final Integer ID = 1000;
    final String USERNAME = "USER";
    final String PASSWORD = "PASSWORD";
    final String EMAIL = "BLOG@JINWENJIE.ME";
    final String IP = "127.0.0.1";

    @Autowired
    UserService userService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void CRUD() {
        User user = new User();
        user.setUserId(ID);
        user.setUserName(USERNAME);
        user.setUserPassword(PASSWORD);
        user.setUserRegistrationDate(new Date());
        user.setUserIp(IP);
        user.setUserEmail(EMAIL);
        userService.delete(ID);
        assertTrue(userService.create(user));
        assertEquals(PASSWORD, userService.get(ID).getUserPassword());
        assertNotEquals(PASSWORD, userService.get(ID).getUserName());
        user.setUserName(PASSWORD);
        assertTrue(userService.update(user));
        assertEquals(PASSWORD, userService.get(ID).getUserName());
        assertTrue(userService.delete(ID));
        assertFalse(userService.delete(ID));
    }

    @Test
    public void accountNullUser() {
        User user = new User();
        user.setUserRegistrationDate(new Date());
        user.setUserIp(IP);
        thrown.expect(CustomException.class);
        System.out.println(userService.create(user));
    }
}