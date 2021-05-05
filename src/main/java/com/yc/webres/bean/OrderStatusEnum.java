package com.yc.webres.bean;

/**
 * program:webres
 * description:
 * author:lsj
 * create:2021-05-04 18:57
 */
public enum OrderStatusEnum {
    NEW(1, "新订单");
    private int code;
    private String desc;

    OrderStatusEnum(int i, String desc) {
        this.code = i;
        this.desc = desc;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
