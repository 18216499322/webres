package com.yc.webres.dao;

import com.yc.webres.bean.OrderStatusEnum;
import com.yc.webres.bean.ResOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResOrderDaoTest {
    @Autowired
    private ResOrderDao dao;

    @Test
    public void addResOrder() {
        ResOrder ro = new ResOrder();
        ro.setAddress("湖南");
        ro.setDeliverytime(new Timestamp(System.currentTimeMillis()));
        ro.setOrdertime(new Timestamp(System.currentTimeMillis()));
        ro.setPs("quick");
        ro.setTel("18216499322");
        ro.setStatus(OrderStatusEnum.NEW.getCode());
        ro.setUserid(1);
        ro = dao.save(ro);
        System.out.println(ro.getRoid());
    }
}