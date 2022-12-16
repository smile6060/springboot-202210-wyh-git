package com.study.springboot202210wyh.service;

import com.study.springboot202210wyh.repository.UserRepository;
import com.study.springboot202210wyh.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto UserDto) {
        int userId = 0;
        userId = userRepository.saveUser(UserDto);
        return userId;
    }

    public UserDto getUser(int userId) {
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);
        return userDto;
    }

}
