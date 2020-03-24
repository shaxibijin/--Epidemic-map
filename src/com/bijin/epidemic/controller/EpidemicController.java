package com.bijin.epidemic.controller;

import com.bijin.epidemic.beans.AjaxResponseInfo;
import com.bijin.epidemic.beans.EpidemicDetailInfo;
import com.bijin.epidemic.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 疫情信息控制层（构建-->构件）
 */
@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {
    @Autowired
    private EpidemicService epidemicService;

    /**
     * 获取疫情信息（组装成json返回到前端，前后台分离）
     */
    @GetMapping("/ajax/lastestData")//get请求
    @ResponseBody//返回json
    public AjaxResponseInfo findLastestData() {
        AjaxResponseInfo responseInfo = new AjaxResponseInfo();
        List<EpidemicDetailInfo> list = this.epidemicService.findLastestData();
        responseInfo.setData(list);
        return responseInfo;
    }
}


