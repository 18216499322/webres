package com.yc.webres.service.impl;

import com.yc.webres.bean.OrderStatusEnum;
import com.yc.webres.bean.ResOrder;
import com.yc.webres.service.ResFoodBiz;
import com.yc.webres.service.ResOrderBiz;
import com.yc.webres.vo.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResOrderBizImplTest {
    @Autowired
    private ResFoodBiz resFoodBiz;
    @Autowired
    private ResOrderBiz resOrderBiz;

    @Test
    public void completeOrder() {
        ResOrder o = new ResOrder();
        o.setUserid(1);
        o.setStatus(OrderStatusEnum.NEW.getCode());
        o.setTel("18216499322");
        o.setPs("快");
        o.setAddress("湖南工学院");
        o.setOrdertime(new Timestamp(System.currentTimeMillis()));
        Map<Integer, CartItem> cart = new HashMap<Integer, CartItem>();

        Integer fid1 = 11;
        CartItem ci1 = new CartItem();
        ci1.setFood(resFoodBiz.findByFid(fid1));
        ci1.setNum(1);

        Integer fid2 = 12;
        CartItem ci2 = new CartItem();
        ci2.setFood(resFoodBiz.findByFid(fid2));
        ci2.setNum(1);

        cart.put(fid1, ci1);
        cart.put(fid2, ci2);
        resOrderBiz.completeOrder(o, cart);
    }
}