package com.whale.homework.third.controller;


import com.whale.homework.third.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String login(){
        return "contact";
    }

    @RequestMapping("/signin")
    public String signin(){
        return "signin";
    }

//    用户登陆
    @RequestMapping("/userlogin")
    public String userlogin(String email, String password, Map map, HttpServletResponse response){
//        对邮箱进行校验
        String reg="[1-9]\\d{7,10}@qq\\.com";
        if(!email.matches(reg)){
            map.put("msg","邮箱格式错误！");
        }

        boolean exit=userService.exitUser(email,password,response);

//        查看用户是否存在
        if(exit){
//            存在返回首页
                return "redirect:/";
        }else{
//            不存在
            map.put("msg","不存在此账号");
            return "contact";
        }
    }



//    用户注册
    @RequestMapping("/usersignin")
    public String userSignIn(String username,String email,String password,Map map){
//        对用户名进行验证
        if(username==""){
            map.put("error","1");
            map.put("msg3","用户名不能为空!");
            map.put("password",password);
            map.put("email",email);
            return "signin";
        }
//        对邮箱进行校验
        String reg="[1-9]\\d{7,10}@qq\\.com";
        if(!email.matches(reg)){
            map.put("error","1");
            map.put("msg1","邮箱格式错误！");
            map.put("username",username);
            map.put("password",password);
            return "signin";
        }
//        对密码进行校验
        if(password.length()<6){
            map.put("error","1");
            map.put("msg2","密码长度不能小于6位!");
            map.put("username",username);
            map.put("email",email);
            return "signin";
        }

//        增加新用户
        userService.addUser(email,password,username);
        return "contact";
    }

//用户退出登陆
    @GetMapping("/logout")
    public String logout(HttpServletResponse response,
                         HttpServletRequest request){
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("cookie",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }



}
