package me.jinwenjie.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class JWTUtilTest {

    final Integer UID = (int) (Math.random() * 10000);

    @Test
    public void verify() {
        String token = JWTUtil.sign(UID);
        assertTrue(JWTUtil.verify(token));
        token = "ajidwadmaskcl";
        assertFalse(JWTUtil.verify(token));
    }

    @Test
    public void expire() {
        String token = JWTUtil.sign(UID, false, 100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(JWTUtil.verify(token));
    }

    @Test
    public void getUserId() {
        String token = JWTUtil.sign(UID);
        assertEquals(UID, JWTUtil.getUserId(token));
    }

    @Test
    public void checkAdmin() {
        String token = JWTUtil.sign(UID, false);
        assertEquals(false, JWTUtil.checkAdmin(token));
        token = JWTUtil.sign(UID, true);
        assertEquals(true, JWTUtil.checkAdmin(token));
    }
}