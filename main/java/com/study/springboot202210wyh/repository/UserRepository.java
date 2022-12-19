package com.study.springboot202210wyh.repository;

import com.study.springboot202210wyh.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

// UserRepository랑 user.xml이랑 연결해주는게 @Mapper임
@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
}
