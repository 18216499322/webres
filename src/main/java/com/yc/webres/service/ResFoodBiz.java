package com.yc.webres.service;

import com.yc.webres.bean.ResFood;

import java.util.List;

/**
 * program:webres
 * description:resfoodbiz
 * author:lsj
 * create:2021-05-04 19:13
 */
public interface ResFoodBiz {
    public List<ResFood> findAll();

    public ResFood findByFid(Integer fid);
}
