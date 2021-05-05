package com.yc.webres.dao;

import com.yc.webres.bean.ResOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * program:webres
 * description:resorderdao
 * author:lsj
 * create:2021-05-04 16:29
 */
public interface ResOrderDao extends JpaRepository<ResOrder, Integer> {
}
