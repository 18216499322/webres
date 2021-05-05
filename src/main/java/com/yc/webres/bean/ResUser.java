package com.yc.webres.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * program:webres
 * description:resuser
 * author:lsj
 * create:2021-04-29 20:03
 */
@Entity(name = "resuser")
@Data
public class ResUser implements Serializable {
    private static final long serialVersionUID = -416298542297164906L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private String pwd;
    private String email;
}
