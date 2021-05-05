package com.yc.webres.dao;

import com.yc.webres.bean.ResOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * program:webres
 * description:resorderitemdao
 * author:lsj
 * create:2021-05-04 16:31
 */
public interface ResOrderItemDao extends JpaRepository<ResOrderItem, Integer> {
}
