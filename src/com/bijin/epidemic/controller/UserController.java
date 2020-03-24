package com.bijin.epidemic.controller;

import com.bijin.epidemic.beans.UserInfo;
import com.bijin.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;
/**
 * 控制层-访问service
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model){
        UserInfo user = userService.findByAccount(userInfo.getAccount());
        if (user == null){
            //帐号不正确
            model.addAttribute("msg","帐号不正确");
            return "login";
        }
        //登录成功
        if(user.getPassword().equals(userInfo.getPassword())){
            return "redirect:/epidemic.jsp";
        }
        model.addAttribute("msg","帐号不正确");
        return "login";
    }
}
