package com.yc.webres.service.impl;

import com.yc.webres.bean.ResFood;
import com.yc.webres.dao.ResFoodeDao;
import com.yc.webres.service.ResFoodBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * program:webres
 * description:resfoodbizimpl
 * author:lsj
 * create:2021-05-04 19:41
 */
@Service
@Transactional
public class ResFoodBizImpl implements ResFoodBiz {
    @Autowired
    private ResFoodeDao resFoodeDao;

    @Override
    @Transactional(readOnly = true)
    public List<ResFood> findAll() {
        return resFoodeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ResFood findByFid(Integer fid) {
        ResFood rf = new ResFood();
        rf.setFid(fid);
        Example<ResFood> example = Example.of(rf);
        Optional<ResFood> opt = resFoodeDao.findOne(example);
        return opt.get();
    }
}
