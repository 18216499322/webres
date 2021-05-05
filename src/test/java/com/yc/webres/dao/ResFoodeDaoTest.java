package com.yc.webres.dao;

import com.yc.webres.bean.ResFood;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResFoodeDaoTest {
    @Autowired
    private ResFoodeDao dao;

    @Test
    public void findResFoodByFid() {
        ResFood rf = new ResFood();
        rf.setFid(13);
        Example<ResFood> example = Example.of(rf);
        Optional<ResFood> opt = dao.findOne(example);
        Assert.assertNotNull(opt.get());
    }

    @Test
    public void addResFood() {
        ResFood rf = new ResFood();
        rf.setFname("辣椒炒肉");
        rf.setFphoto("50026.jpj");
        rf.setDetail("good");
        BigDecimal np = new BigDecimal(30.0);
        rf.setNormprice(np);
        rf.setRealprice(new BigDecimal(40.0));
        dao.save(rf);
    }
}