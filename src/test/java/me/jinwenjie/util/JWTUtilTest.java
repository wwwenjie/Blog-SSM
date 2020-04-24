package me.jinwenjie.util;

import org.junit.Assert;
import org.junit.Test;

public class JWTUtilTest {

    final Integer UID = (int) (Math.random() * 10000);

    @Test
    public void verify() {
        String token = JWTUtil.sign(UID);
        Assert.assertTrue(JWTUtil.verify(token));
        token = "ajidwadmaskcl";
        Assert.assertFalse(JWTUtil.verify(token));
    }

    @Test
    public void expire() {
        String token = JWTUtil.sign(UID, false, 100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(JWTUtil.verify(token));
    }

    @Test
    public void getUserId() {
        String token = JWTUtil.sign(UID);
        Assert.assertEquals(JWTUtil.getUserId(token), UID);
    }

    @Test
    public void checkAdmin() {
        String token = JWTUtil.sign(UID, false);
        Assert.assertEquals(JWTUtil.checkAdmin(token), false);
        token = JWTUtil.sign(UID, true);
        Assert.assertEquals(JWTUtil.checkAdmin(token), true);
    }
}