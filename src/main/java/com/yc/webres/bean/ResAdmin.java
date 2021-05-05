package com.yc.webres.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * program:webres
 * description:resadmin
 * author:lsj
 * create:2021-04-29 19:51
 */
@Entity(name = "resadmin")
@Data
public class ResAdmin implements Serializable {
    private static final long serialVersionUID = -1834952306841441131L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer raid;
    private String raname;
    private String rapwd;
}
