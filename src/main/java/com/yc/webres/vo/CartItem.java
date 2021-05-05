package com.yc.webres.vo;

import com.yc.webres.bean.ResFood;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * program:webres
 * description:cartitem
 * author:lsj
 * create:2021-05-04 19:10
 */
@Data
public class CartItem implements Serializable {
    private static final long serialVersionUID = 94079114800768032L;
    private ResFood food;
    private int num;
    private BigDecimal smallCount;

    public BigDecimal getSmallCount() {
        this.smallCount = food.getRealprice().multiply(new BigDecimal(num));
        return smallCount;
    }
}
