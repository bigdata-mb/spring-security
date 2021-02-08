package com.manba.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: manba
 */
@Controller
public class MainController {

    @RequestMapping({"/index", "/", ""})
    public String index() {
        return "index";// resources/templates/index.html
    }

}
