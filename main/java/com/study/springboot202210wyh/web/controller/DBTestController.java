package com.study.springboot202210wyh.web.controller;

import com.study.springboot202210wyh.service.UserService;
import com.study.springboot202210wyh.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        // 밑에꺼는 빌더 형식으로 잡는 방법이다. 둘다 결과는 같음
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
