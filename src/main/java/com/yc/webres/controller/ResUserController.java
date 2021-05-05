package com.yc.webres.controller;

import com.yc.webres.bean.ResUser;
import com.yc.webres.service.ResUserBiz;
import com.yc.webres.vo.JsonModel;
import com.yc.webres.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.yc.webres.util.YcConstants.*;

/**
 * program:webres
 * description:resusercontroller
 * author:lsj
 * create:2021-05-05 10:08
 */
@RestController
@Api(description = "小萌神网络订餐系统操作接口", tags = {"用户登录部分", "控制层"})
public class ResUserController {
    @Autowired
    private ResUserBiz resUserBiz;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public JsonModel loginOp(HttpSession session, JsonModel jm, UserVo userVo) {
        if (userVo.getValcode() == null || "".equals(userVo.getValcode())) {
            jm.setCode(0);
            jm.setMsg("验证码不能为空");
            return jm;
        }
        String validateCode = (String) session.getAttribute("validateCode");
        if (!userVo.getValcode().equalsIgnoreCase(validateCode)) {
            jm.setCode(0);
            jm.setMsg("验证码错误");
            return jm;
        }
        ResUser u = new ResUser();
        u.setUsername(userVo.getUsername());
        u.setPwd(userVo.getPwd());
        ResUser users = resUserBiz.login(u);
        if (users != null) {
            session.setAttribute(LOGINUSER, users);
            jm.setCode(1);
            if (session.getAttribute(LASTLOCATION) != null) {
                jm.setUrl((String) session.getAttribute(LASTLOCATION));
            } else {
                jm.setUrl(HOMEPAGE);
            }
        } else {
            jm.setCode(0);
            jm.setMsg("Wrong username or password,please try again");
        }
        return jm;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "用户登出", notes = "用户登出")
    public JsonModel logout(JsonModel jm, HttpSession session) {
        session.removeAttribute(LOGINUSER);
        jm.setCode(1);
        return jm;
    }

    @RequestMapping(value = "/checkLogin", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "检查登录", notes = "检查登录")
    public JsonModel checkLoginOp(JsonModel jm, HttpSession session) {
        if (session.getAttribute(LOGINUSER) == null) {
            jm.setCode(0);
            jm.setMsg("用户没有登录");
        } else {
            jm.setCode(1);
            ResUser u = (ResUser) session.getAttribute(LOGINUSER);
            jm.setObj(u);
        }
        return jm;
    }
}
