package com.yc.webres.service;

import com.yc.webres.bean.ResOrder;
import com.yc.webres.vo.CartItem;

import java.util.Map;

/**
 * program:webres
 * description:resorderbiz
 * author:lsj
 * create:2021-05-04 19:14
 */
public interface ResOrderBiz {
    public Integer completeOrder(ResOrder resOrder, Map<Integer, CartItem> shopCoart);
}
