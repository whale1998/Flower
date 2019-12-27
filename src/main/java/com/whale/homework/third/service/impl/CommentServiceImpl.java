package com.whale.homework.third.service.impl;

import com.whale.homework.third.DTO.CommentDTO;
import com.whale.homework.third.entity.Comment;
import com.whale.homework.third.entity.User;
import com.whale.homework.third.mapper.CommentMapper;
import com.whale.homework.third.mapper.UserMapper;
import com.whale.homework.third.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<CommentDTO> findComments(int fid) {
        List<CommentDTO> commentDTOS= new ArrayList<>();

        Example example = new Example(Comment.class);
        example.and().andEqualTo("flowerid",fid);
        List<Comment> commentList = commentMapper.selectByExample(example);
        for (Comment comment : commentList) {
            Integer userid = comment.getUserid();
            User user = userMapper.selectByPrimaryKey(userid);
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setContent(comment.getContent());
            commentDTO.setUseranme(user.getName());
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }

    public void addComment(String content, User user, int flowerid) {
        Integer userId = user.getId();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserid(userId);
        comment.setFlowerid(flowerid);
        comment.setCreatetime(System.currentTimeMillis());

//        添加评论
        commentMapper.insertSelective(comment);
    }
}
