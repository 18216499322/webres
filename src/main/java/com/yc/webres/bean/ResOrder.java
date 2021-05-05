package com.yc.webres.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * program:webres
 * description:resorder
 * author:lsj
 * create:2021-04-29 19:55
 */
@Entity(name = "resorder")
@Data
public class ResOrder implements Serializable {
    private static final long serialVersionUID = 5650450361551346071L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roid;
    private Integer userid;
    private String address;
    private String tel;
    private Timestamp ordertime;
    private Timestamp deliverytime;
    private String ps;
    private Integer status;
}
