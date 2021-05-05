package com.yc.webres.dao;

import com.yc.webres.bean.ResFood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * program:webres
 * description:resfooddao
 * author:lsj
 * create:2021-05-04 16:31
 */
public interface ResFoodeDao extends JpaRepository<ResFood, Integer> {
}
