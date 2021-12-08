package com.example.week7task.service;


import com.example.week7task.model.UserInfo;

import java.util.List;

@org.springframework.stereotype.Service
public interface UserServices {
    List<UserInfo> findAllUser();

    UserInfo saverUser(UserInfo userInfo);

    UserInfo authenticate(String email, String password);
}
