package com.manba.security.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * descriptions: 用户登录
 * author: clark
 * date: 2021 -02 -08
 */
@Controller
public class CustomLoginController {

    @RequestMapping("/login/page")
    public String toLogin(){
        return "login";
    }






}
