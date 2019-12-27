package com.whale.homework.third.service;

import com.whale.homework.third.DTO.CommentDTO;
import com.whale.homework.third.entity.User;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findComments(int fid);

    void addComment(String content, User user, int flowerid);
}
