package com.yc.webres.service.impl;

import com.yc.webres.bean.ResOrder;
import com.yc.webres.bean.ResOrderItem;
import com.yc.webres.dao.ResOrderDao;
import com.yc.webres.dao.ResOrderItemDao;
import com.yc.webres.service.ResOrderBiz;
import com.yc.webres.vo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * program:webres
 * description:resorderbizimpl
 * author:lsj
 * create:2021-05-04 19:42
 */
@Service
@Transactional
public class ResOrderBizImpl implements ResOrderBiz {
    @Autowired
    private ResOrderDao resOrderDao;
    @Autowired
    private ResOrderItemDao resOrderItemDao;

    @Override
    public Integer completeOrder(ResOrder resOrder, Map<Integer, CartItem> shopCoart) {
        ResOrder orderResult = resOrderDao.save(resOrder);
        if (shopCoart != null && shopCoart.size() > 0) {
            for (Map.Entry<Integer, CartItem> entry : shopCoart.entrySet()) {
                ResOrderItem ri = new ResOrderItem();
                ri.setRoid(orderResult.getRoid());
                ri.setNum(entry.getValue().getNum());
                ri.setFid(entry.getKey());
                ri.setDealprice(entry.getValue().getFood().getRealprice());
                resOrderItemDao.save(ri);
            }
        }
        return orderResult.getRoid();
    }
}
