package com.manba.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理
 * @Auther:
 */
@Controller
@RequestMapping("/permission")
public class SysPermissionController {

    private static final String HTML_PREFIX = "system/permission/";

    @GetMapping(value = {"/", ""}) // /permission/  /permission
    public String permission() {
        return HTML_PREFIX + "permission-list";
    }

}
