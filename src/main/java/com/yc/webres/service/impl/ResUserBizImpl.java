package com.yc.webres.service.impl;

import com.yc.webres.bean.ResUser;
import com.yc.webres.dao.ResUserDao;
import com.yc.webres.service.ResUserBiz;
import com.yc.webres.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * program:webres
 * description:resuserbizimpl
 * author:lsj
 * create:2021-05-04 19:41
 */
@Service
public class ResUserBizImpl implements ResUserBiz {
    @Autowired
    private ResUserDao resUserDao;

    @Override
    @Transactional(readOnly = true)
    public ResUser login(ResUser user) {
        user.setPwd(Encrypt.md5(user.getPwd()));
        Example<ResUser> example = Example.of(user);
        Optional<ResUser> optional = resUserDao.findOne(example);
        return optional.get();
    }
}
