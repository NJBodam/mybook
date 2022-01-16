package com.example.mybook.service;


import com.example.mybook.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    List<UserInfo> findAllUser();

    UserInfo saverUser(UserInfo userInfo);

    UserInfo authenticate(String email, String password);
}
