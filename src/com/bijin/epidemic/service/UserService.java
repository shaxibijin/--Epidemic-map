package com.bijin.epidemic.service;

import com.bijin.epidemic.beans.UserInfo;

/**
 * 业务处理-访问mapper
 */
public interface UserService {
    /**
     * 根据用户的帐号获取用户信息
     */
    UserInfo findByAccount(String account);
}
