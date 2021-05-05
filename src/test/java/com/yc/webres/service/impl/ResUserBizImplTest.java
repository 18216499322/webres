package com.yc.webres.service.impl;

import com.yc.webres.bean.ResUser;
import com.yc.webres.service.ResUserBiz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResUserBizImplTest {
    @Autowired
    private ResUserBiz resUserBiz;

    @Test
    public void login() {
        ResUser u = new ResUser();
        u.setUsername("a");
        u.setPwd("a");
        ResUser r = resUserBiz.login(u);
        Assert.assertNotNull(r);
    }
}