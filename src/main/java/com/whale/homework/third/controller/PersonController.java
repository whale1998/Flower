package com.whale.homework.third.controller;

import com.whale.homework.third.entity.Flower;
import com.whale.homework.third.entity.User;
import com.whale.homework.third.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonServiceImpl personService;


    @RequestMapping("/person")
    public String person(){
        return "usercenter";
    }

//    个人中心
    @RequestMapping("/personalInfo")
    public String personalInfo(HttpServletRequest request,
                               Model map){
        //        检查用户是否登陆
        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            return "contact";
        }
        map.addAttribute("user",user);
        return "user";
    }

//    收藏功能
    @RequestMapping("/mycollection")
    public String mycollection(HttpServletRequest request,
                               Model map){
        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            return "contact";
        }

        Integer userId = user.getId();
        List<Flower> flowers = personService.showcollection(userId);
        if(flowers!=null){
            map.addAttribute("flowers",flowers);
        }

        return "collection";
    }

//    删除收藏
    @RequestMapping("/deletecol")
    @ResponseBody
    public String deletecol(@RequestParam("fid") String fid,
                            HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            return "contact";
        }

        Integer userId = user.getId();
        personService.deletecol(userId,fid);
        return "success";
    }

}
