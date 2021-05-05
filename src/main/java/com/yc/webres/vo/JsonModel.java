package com.yc.webres.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * program:webres
 * description:
 * author:lsj
 * create:2021-05-05 09:26
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonModel implements Serializable {
    private static final long serialVersionUID = -6504421638304640464L;
    private Integer code;
    private String msg;
    private Object obj;
    private String url;
}
