package com.springbootwithmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/index")
    public String dashboard(){
        return "login_dashboard";
    }

}
