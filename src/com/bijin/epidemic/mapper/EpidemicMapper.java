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
    @Select(value = "SELECT el.`province_id`,temp.province_name,el.`data_day`,el.`data_month`,el.`data_year`, " +
            " temp.affirmed_total,temp.suspected_total,temp.isolated_total,temp.cured_total,temp.dead_total " +
            " FROM epidemics el RIGHT OUTER JOIN( " +
            " SELECT e.`province_id`,p.`province_name`,SUM(e.`affirmed`) affirmed_total, " +
            " SUM(e.`suspected`) suspected_total,SUM(e.`isolated`) isolated_total, " +
            " SUM(e.`cured`) cured_total,SUM(e.`dead`) dead_total  " +
            " FROM epidemics e RIGHT OUTER JOIN provinces p ON e.`province_id`=p.`province_id` " +
            " GROUP BY e.`province_id`,p.`province_name` " +
            " ) " +
            " temp ON el.`province_id`=temp.province_id " +
            " WHERE el.`data_year`=#{year} " +
            " AND el.`data_month`=#{month} " +
            " AND el.`data_day`=#{day}")
    List<EpidemicDetailInfo> findLastestData(Map<String,Short> condition);
}
