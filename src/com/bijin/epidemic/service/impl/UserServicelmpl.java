package com.bijin.epidemic.service.impl;

import com.bijin.epidemic.beans.UserInfo;
import com.bijin.epidemic.mapper.UserMapper;
import com.bijin.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServicelmpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}
