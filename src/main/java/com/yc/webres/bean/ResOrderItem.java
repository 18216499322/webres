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
 * description:resorderitem
 * author:lsj
 * create:2021-04-29 19:59
 */
@Entity(name = "resorderitem")
@Data
public class ResOrderItem implements Serializable {
    private static final long serialVersionUID = 8641072657410411557L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roiid;
    private Integer roid;
    private Integer fid;
    private BigDecimal dealprice;
    private Integer num;
}
