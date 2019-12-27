package com.whale.homework.third.controller;


import com.whale.homework.third.entity.User;
import com.whale.homework.third.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    //   发表评论
    @RequestMapping("/comment")
    @ResponseBody
    public String comment(@RequestParam("fid") String flowerid, String content, HttpServletRequest request){
//        检查用户是否登陆
        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            return "fail";
        }
//        添加评论
        int fid = Integer.parseInt(flowerid);
        commentService.addComment(content,user,fid);
        return "success";
    }




}
