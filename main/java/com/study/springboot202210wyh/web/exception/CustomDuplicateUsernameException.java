package com.study.springboot202210wyh.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomDuplicateUsernameException extends RuntimeException {

    //Getter가 있어야지 제이슨 errorMap 을 쓸 수 있다.
    @Getter
    private Map<String, String> errorMap;

    public CustomDuplicateUsernameException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
