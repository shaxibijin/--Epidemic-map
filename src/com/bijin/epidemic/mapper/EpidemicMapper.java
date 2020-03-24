package com.bijin.epidemic.mapper;

import com.bijin.epidemic.beans.EpidemicDetailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 疫情信息数据访问层
 */
@Mapper
public interface  EpidemicMapper {
    /**
     * 需求：根据日期（年月日）查询疫情信息（省份名称、确诊人数、疑似人数隔离人数、治愈人数、死亡人数）
     */
    @Select(value = "SELECT e1.`province_id`,temp.province_name,e1.`data_year`,e1.`data_month`,e1.`data_day`, " +
            "temp.affirmed_total,temp.suspected_total,temp.isolated_total,temp.cured_total,temp.dead_total " +
            " FROM epidemics e1 RIGHT OUTER JOIN (SELECT e.`province_id`,p.`province_name`,SUM(e.`affirmed`) affirmed_total, " +
            " SUM(e.`suspected`) suspected_total,SUM(e.`isolated`) isolated_total, " +
            " SUM(e.`cured`) cured_total,SUM(e.`dead`) dead_total " +
            " FROM epidemics e RIGHT OUTER JOIN provinces p ON e.`province_id`=p.`province_id` " +
            " GROUP BY e.`province_id`,p.`province_name`) temp ON e1.`province_id` = temp.province_id " +
            " WHERE e1.`data_year`=2020 AND e1.`data_month`=3 AND e1.`data_day`=24")
    //" WHERE e1.`data_year`=#{year} AND e1.`data_month`=#{month} AND e1.`data_day`=#{day}"
    List<EpidemicDetailInfo> findLastestData(Map<String,Short> condition);
}
