package com.bijin.epidemic.service.impl;

import com.bijin.epidemic.beans.EpidemicDetailInfo;
import com.bijin.epidemic.beans.EpidemicInfo;
import com.bijin.epidemic.mapper.EpidemicMapper;
import com.bijin.epidemic.service.EpidemicService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 疫情数据实现类
 */
@Service
public class EpidemicServiceImpl implements EpidemicService {
    @Autowired
    private EpidemicMapper epidemicMapper;
    /**
     * 获取最新疫情数据信息
     *
     * @return
     */
    @Override
    public List<EpidemicDetailInfo> findLastestData() {
        //查询每个省份的累积数量和当日新增数量
        Calendar calendar = new GregorianCalendar();//获取当前日期
        short year = 0,month = 0,day = 0;
        year = (short)calendar.get(Calendar.YEAR);
        month = (short)calendar.get(Calendar.MONTH);
        day = (short)calendar.get(Calendar.DATE);

        //将数据封装到Map集合中
        Map<String,Short> condition = new HashMap<>();
        condition.put("year",year);
        condition.put("month",month);
        condition.put("day",day);

        //查询每个省份的累积数据和当日新增数据
        List<EpidemicDetailInfo> list = this.epidemicMapper.findLastestData(condition);
        return list;
    }
}
