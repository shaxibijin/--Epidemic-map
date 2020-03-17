package com.bijin.epidemic.service;

import com.bijin.epidemic.beans.EpidemicDetailInfo;


import java.util.List;

/**
 * 疫情信息的业务处理接口
 */
public interface EpidemicService {
    /**
     * 获取最新疫情数据信息
     * @return
     */
    List<EpidemicDetailInfo> findLastestData();
}
