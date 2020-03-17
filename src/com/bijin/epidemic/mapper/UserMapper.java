package com.bijin.epidemic.mapper;

import com.bijin.epidemic.beans.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 数据访问层-访问数据库
 *          实现对数据库的CRUD
 */
@Mapper
public interface UserMapper {
    /**
     * 根据账户查询对应的用户信息
     */
    @Select(value="SELECT user_id,account,PASSWORD,user_name FROM users WHERE account = #{account} AND  del_flag=0")
    UserInfo findByAccount(String account);
}
