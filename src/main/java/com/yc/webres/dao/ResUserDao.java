package com.yc.webres.dao;

import com.yc.webres.bean.ResUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * program:webres
 * description:resuserdao
 * author:lsj
 * create:2021-05-04 16:27
 */
public interface ResUserDao extends JpaRepository<ResUser, Integer> {
}
