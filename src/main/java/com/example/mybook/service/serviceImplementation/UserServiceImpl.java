package com.example.mybook.service.serviceImplementation;

import com.example.mybook.model.UserInfo;
import com.example.mybook.repository.UserRepository;
import com.example.mybook.service.UserServices;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserInfo> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo saverUser(UserInfo userInfo) {
        if (userRepository.findByEmail(userInfo.getEmail()).isPresent()) {
            System.out.println("This mail is in use");
            return null;
        }
        return userRepository.save(userInfo);
    }

    @Override
    public UserInfo authenticate(String email, String password){
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

}

