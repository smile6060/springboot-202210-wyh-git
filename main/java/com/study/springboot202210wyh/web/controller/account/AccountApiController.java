package com.study.springboot202210wyh.web.controller.account;

import com.study.springboot202210wyh.service.UserService;
import com.study.springboot202210wyh.web.dto.CMRespDto;
import com.study.springboot202210wyh.web.dto.UserDto;
import com.study.springboot202210wyh.web.dto.UsernameDto;
import com.study.springboot202210wyh.web.exception.CustomValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    //  public ResponseEntity<?> duplicateUsername(@RequestParam String username) {
    // 변수명이랑 일치하면 생략가능
//    public ResponseEntity<?> duplicateUsername(@NotBlank(message = "사용자 이름을 입력하세요.") String username) {
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자 이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }

}
