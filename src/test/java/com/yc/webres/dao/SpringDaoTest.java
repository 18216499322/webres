package com.yc.webres.dao;

import com.yc.webres.bean.Spring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDaoTest {
    @Autowired
    private SpringDao springDao;

    @Test
    public void insert() {
        springDao.insert(new Spring(1, 20, "张三"));
    }

    @Test
    public void update() {
        springDao.update("age", 1, 100);
    }

    @Test
    public void findByName() {
        System.out.println(springDao.findByName("张三"));
    }

    @Test
    public void delete() {
        springDao.delete(1);
    }
}