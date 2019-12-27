package com.whale.homework.third.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {

//    跳转主页
    @RequestMapping("/")
    public String index(){
        return "index";
    }

//跳转services
    @RequestMapping("/services")
    public String services(){
        return "services";
    }

//    跳转分类
    @RequestMapping("/portfolio")
    public String portfolio(){
        return "portfolio";
    }

    @RequestMapping("/siginin")
    public String siginin(){
        return "signin";
    }

    @RequestMapping("/restart")
    public String contact(){
        return "contact";
    }

}

