package com.study.springboot202210wyh.web.controller;

import com.study.springboot202210wyh.web.dto.CMRespDto;
import com.study.springboot202210wyh.web.dto.UserDto;
import com.study.springboot202210wyh.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

//    @GetMapping("/api/test/user-dto/obj")
//    public UserDto getUserDtoObj(HttpServletResponse response) {
//        UserDto userDto = UserDto.builder()
//                .userId(100)
//                .username("abc")
//                .password("1234")
//                .build();
//        response.setStatus(400);
//        return userDto;
//    }
    // 위에껄로 해야하는데 추상화 시킨것이 ResponseEntity이다. 밑에 참조
    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);



//        return ResponseEntity.badRequest().body("");
        // badRequest()가 올 수도 있다.
        // return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto);
        // 직관적으로 보인다. 위에꺼
        // builder가 밑에꺼를 위에껄로 가능하다.
//        return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        //HttpStatus.BAD_REQUEST 400번대를 지정할 수 있음.
        //INTERNAL_SERVER_ERROR 500번대 지정할 수 있음.
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto() {
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
//        return ResponseEntity.ok().body(CMRespDto.<UserDto>builder().message("test유저 정보 응답").data(userDto));
        return ResponseEntity.ok().body(new CMRespDto<>("test 유저 정보 응답", null));

    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {

        if(userDto.getUsername().isBlank()) {
            Map<String,String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));

    }
}
