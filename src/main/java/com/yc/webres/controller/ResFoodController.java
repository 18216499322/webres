package com.yc.webres.controller;

import com.yc.webres.bean.ResFood;
import com.yc.webres.bean.ResOrder;
import com.yc.webres.service.ResFoodBiz;
import com.yc.webres.service.ResOrderBiz;
import com.yc.webres.vo.JsonModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.yc.webres.util.YcConstants.RESFOOFLIST;

/**
 * program:webres
 * description:resfoodcontroller
 * author:lsj
 * create:2021-05-05 08:43
 */
@RestController
@Slf4j
@Api(description = "小萌神网络订餐系统操作接口", tags = {"菜品操作部分", "控制层"})
public class ResFoodController {
    @Autowired
    private ResFoodBiz resFoodBiz;
    @Autowired
    private ResOrderBiz resOrderBiz;

    @RequestMapping(value = "/findAllFoods", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "查询所有菜", notes = "查询所有菜")
    public JsonModel findAllFoods(HttpSession session, JsonModel jm) {
        List<ResFood> list = resFoodBiz.findAll();
        session.setAttribute(RESFOOFLIST, list);
        jm.setCode(1);
        jm.setObj(list);
        return jm;
    }

    @RequestMapping(value = "/findFood", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "根据id查找菜品", notes = "根据id查找菜品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fid", value = "菜品编号", required = true)
    })
    public JsonModel findFood(HttpSession session, ResFood food, JsonModel jm) {
        List<ResFood> list = null;
        if (session.getAttribute(RESFOOFLIST) != null) {
            list = (List<ResFood>) session.getAttribute(RESFOOFLIST);
        } else {
            list = resFoodBiz.findAll();
            session.setAttribute(RESFOOFLIST, list);
        }
        for (ResFood r : list) {
            if (food.getFid().equals(r.getFid())) {
                jm.setCode(1);
                jm.setObj(r);
                return jm;
            }
        }
        jm.setCode(0);
        return jm;
    }

    @RequestMapping(value = "confirmOrder", method = RequestMethod.POST)
    @ApiOperation(value = "确认订单", notes = "确认订单")
    public JsonModel confirmOrder(HttpSession session, ResOrder resOrder, JsonModel jm) {
        return null;
    }

}
