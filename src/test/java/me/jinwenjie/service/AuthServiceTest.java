package me.jinwenjie.service;

import me.jinwenjie.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AuthServiceTest extends BaseTest {
    @Autowired
    AuthService authService;

    @Test
    public void isAdmin() {
        assertTrue(authService.isAdmin(1));
        assertFalse(authService.isAdmin(2));
    }

}