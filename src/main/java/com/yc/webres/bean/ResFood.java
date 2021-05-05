package com.yc.webres.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * program:webres
 * description:resfood
 * author:lsj
 * create:2021-04-29 19:53
 */
@Entity(name = "resfood")
@Data
public class ResFood implements Serializable {
    private static final long serialVersionUID = 6726027155850157645L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;
    private String fname;
    private BigDecimal normprice;
    private BigDecimal realprice;
    private String detail;
    private String fphoto;
}
