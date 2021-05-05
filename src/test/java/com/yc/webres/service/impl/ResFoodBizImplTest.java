package com.yc.webres.service.impl;

import com.yc.webres.bean.ResFood;
import com.yc.webres.service.ResFoodBiz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResFoodBizImplTest {

    @Autowired
    private ResFoodBiz resFoodBiz;

    @Test
    public void findAll() {
        List<ResFood> list = resFoodBiz.findAll();
        System.out.println(list);
    }

    @Test
    public void findByFid() {
        ResFood r = resFoodBiz.findByFid(13);
        Assert.assertNotNull(r);
    }
}