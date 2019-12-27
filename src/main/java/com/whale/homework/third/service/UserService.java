package com.whale.homework.third.service;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
     boolean exitUser(String email, String password, HttpServletResponse response);
     void addUser(String email, String password, String username);
}
