package com.whale.homework.third.controller;

import com.whale.homework.third.entity.User;
import com.whale.homework.third.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CollectionController {

    @Autowired
    UserServiceImpl userService;


//  收藏功能
    @RequestMapping("/collection")
    @ResponseBody
    public String collage(@RequestParam("fid") String fid,
                          HttpServletRequest request){
        //        检查用户是否登陆
        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            return "fail";
        }

        Integer userId = user.getId();
        int flowerid = Integer.parseInt(fid);
        userService.collection(userId,flowerid);

        return "success";
    }
}
