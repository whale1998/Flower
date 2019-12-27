package com.whale.homework.third.controller;


import com.whale.homework.third.DTO.CommentDTO;
import com.whale.homework.third.entity.Flower;
import com.whale.homework.third.mapper.CommentMapper;
import com.whale.homework.third.mapper.FlowerMapper;
import com.whale.homework.third.mapper.UserMapper;
import com.whale.homework.third.service.impl.CommentServiceImpl;
import com.whale.homework.third.service.impl.FlowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FlowerController {

    @Autowired
    FlowerMapper flowerMapper;
    @Autowired
    FlowerServiceImpl flowerService;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentServiceImpl commentService;


    @RequestMapping("/blog")
    public String blog(Model map){
//        展示第一篇
        List<Flower> flowers = flowerMapper.selectAll();
        map.addAttribute("flowers",flowers);
        return "blog";
    }



    @RequestMapping("/getflower/{fid}")
    public String getFlower(@PathVariable("fid")int fid, Model map){

//        展示当前花的信息
        Flower flower = flowerMapper.selectByPrimaryKey(fid);
        map.addAttribute("nowFlower",flower);

//        展示留言信息

        List<CommentDTO> commentDTOS=commentService.findComments(fid);

        map.addAttribute("commentDTOS",commentDTOS);

        return "flower";
    }



//    通过关键字搜索
    @RequestMapping("/search")
    public String searchKey(String keyWord,Map map){
        String keyword= "%"+keyWord+"%";
        List<Flower> flowerList = flowerMapper.searchKey(keyword);
        if(flowerList!=null && flowerList.size()!=0){
        map.put("flowerList",flowerList);
        }else{
            map.put("sereachnothing","1");
            map.put("msg","没有找到该文章哦！");
        }

        return "blog";
    }




}
