package com.whale.homework.third.service.impl;

import com.whale.homework.third.entity.Collections;
import com.whale.homework.third.entity.User;
import com.whale.homework.third.mapper.CollectionsMapper;
import com.whale.homework.third.mapper.FlowerMapper;
import com.whale.homework.third.mapper.UserMapper;
import com.whale.homework.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    CollectionsMapper collectionsMapper;

//    用户登陆——用户是否存在
    public boolean exitUser(String email, String password, HttpServletResponse response) {
//        查看用户是否存在
        Example example = new Example(User.class);
        example.and().andEqualTo("email",email);
        User user = userMapper.selectOneByExample(example);
        if (user!=null) {
//            存在 -校验密码
            if (user.getPwd().equals(password)) {
//                写入cookie
                String token = UUID.randomUUID().toString();

//                token存入数据库
                User newUser = new User();
                newUser.setToken(token);
                Example o = new Example(User.class);
                o.and().andEqualTo("email",email);
                userMapper.updateByExampleSelective(newUser, o);

                Cookie cookie = new Cookie("cookie", token);
                cookie.setMaxAge(604800000);
                response.addCookie(cookie);
//                用户存在
                return true;
            }
        }
//        用户不存在
            return false;
    }

//  用户注册——新增用户
    public void addUser(String email, String password, String username) {
        User user = new User();
        user.setEmail(email);
        user.setPwd(password);
        user.setName(username);
        userMapper.insertSelective(user);
    }

//    新增收藏
    public void collection(Integer userId, int flowerid) {
        Collections collections = new Collections();
        collections.setFid(flowerid);
        collections.setUserid(userId);
        collectionsMapper.insertSelective(collections);
    }
}
