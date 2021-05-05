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
 * description:resorderitemtemp
 * author:lsj
 * create:2021-04-29 20:01
 */
@Entity(name = "resorderitemtemp")
@Data
public class ResOrderItemTemp implements Serializable {
    private static final long serialVersionUID = 1554530874351069218L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roitid;
    private Integer fid;
    private Integer num;
    private Timestamp quittime;
    private Integer userid;
}
