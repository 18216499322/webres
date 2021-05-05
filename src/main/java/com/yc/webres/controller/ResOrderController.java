package com.yc.webres.controller;

import com.yc.webres.bean.ResFood;
import com.yc.webres.service.ResFoodBiz;
import com.yc.webres.vo.CartItem;
import com.yc.webres.vo.JsonModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.yc.webres.util.YcConstants.CART;
import static com.yc.webres.util.YcConstants.RESFOOFLIST;

/**
 * program:webres
 * description:resordercontroller
 * author:lsj
 * create:2021-05-05 16:03
 */
@RestController
@Api(description = "小萌神网络订餐系统操作接口", tags = {"订单处理部分", "控制层"})
public class ResOrderController {
    @Autowired
    private ResFoodBiz resFoodBiz;

    @RequestMapping(value = "/orderJson", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "添加购物车", notes = "添加购物车")
    public JsonModel orderJsonOp(HttpServletRequest request, JsonModel jm, HttpSession session) {
        commonOrder(request, session);
        jm.setCode(1);
        return jm;
    }

    private void commonOrder(HttpServletRequest request, HttpSession session) {
        int fid = Integer.parseInt(request.getParameter("fid"));
        int num = Integer.parseInt(request.getParameter("num"));
        List<ResFood> list = null;
        if (session.getAttribute(RESFOOFLIST) != null) {
            list = (List<ResFood>) session.getAttribute(RESFOOFLIST);
        } else {
            list = resFoodBiz.findAll();
            session.setAttribute(RESFOOFLIST, list);
        }
        ResFood food = null;
        for (ResFood r : list) {
            if (r.getFid() == fid) {
                food = r;
                break;
            }
        }
        Map<Integer, CartItem> cart = null;
        if (session.getAttribute(CART) != null) {
            cart = (Map<Integer, CartItem>) session.getAttribute(CART);
        } else {
            cart = new HashMap<Integer, CartItem>();
        }
        CartItem ci = null;
        if (cart.containsKey(fid)) {
            ci = cart.get(fid);
            int newNum = ci.getNum() + num;
            ci.setNum(newNum);
        } else {
            ci = new CartItem();
            ci.setFood(food);
            ci.setNum(num);
        }
        if (ci.getNum() <= 0) {
            cart.remove(fid);
        } else {
            ci.getSmallCount();
            cart.put(fid, ci);
        }
        session.setAttribute(CART, cart);
    }

    @RequestMapping(value = "/getCartInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "查看购物车", notes = "查看购物车")
    public JsonModel getCartInfoOp(HttpServletRequest request, HttpSession session, JsonModel jm) {
        List<CartItem> list = new ArrayList<CartItem>();
        if (session.getAttribute(CART) != null) {
            jm.setCode(1);
            Map<Integer, CartItem> cart = null;
            cart = (Map<Integer, CartItem>) session.getAttribute(CART);
            Set<Integer> sets = cart.keySet();
            Iterator<Integer> iterator = sets.iterator();
            while (iterator.hasNext()) {
                int x = iterator.next();
                list.add(cart.get(x));
            }
            jm.setObj(list);
        } else {
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping(value = "/delorder", method = RequestMethod.GET)
    @ApiOperation(value = "删除订单", notes = "删除订单")
    public JsonModel delOrder(HttpSession session, JsonModel jm, ResFood food) {
        int fid = food.getFid();
        Map<Integer, CartItem> cart = null;
        if (session.getAttribute(CART) != null) {
            cart = (Map<Integer, CartItem>) session.getAttribute(CART);
        } else {
            cart = new HashMap<Integer, CartItem>();
        }
        if (cart.containsKey(fid)) {
            cart.remove(fid);
            jm.setCode(1);
        } else {
            jm.setCode(0);
        }
        session.setAttribute(CART, cart);
        return jm;
    }

    @RequestMapping(value = "/clearAll", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "清空购物车", notes = "清空购物车")
    public JsonModel clearAllOp(HttpSession session, JsonModel jm) {
        session.removeAttribute(CART);
        jm.setCode(1);
        return jm;
    }
}
