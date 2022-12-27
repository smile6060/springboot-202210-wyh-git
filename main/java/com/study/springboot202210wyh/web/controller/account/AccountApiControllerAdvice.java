package com.study.springboot202210wyh.web.controller.account;

import com.study.springboot202210wyh.web.dto.CMRespDto;
import com.study.springboot202210wyh.web.exception.CustomDuplicateUsernameException;
import com.study.springboot202210wyh.web.exception.CustomValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    //Validation이 실패하면 ConstraintViolationException 이 예외가 발생한다. 그래서 ConstraintViolationException이거를 씀
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e) {
        //밑에 코드들이 '공백일 수 없습니다' 이거 띄워줌
//        AccountApiControllerAdvice여기에서 (@NotBlank(message = "사용자 이름을 입력하세요.") String username) 이렇게 해줌으로 띄워지는 메세지 변경 가능
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(e.getConstraintViolations());
        e.getConstraintViolations().forEach(error -> {
//            toString를 통해서 앞에 메소드를 들고 올 수 있음.
            String errorProperty = error.getPropertyPath().toString();
            // . 다음부터 해당되록 하기 위해 +1 붙임
            errorProperty = errorProperty.substring(errorProperty.lastIndexOf(".") + 1);
            errorMap.put(errorProperty, error.getMessage());
        });

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), errorMap));
    }

    @ExceptionHandler(CustomValidException.class)
    public ResponseEntity<?> validationError(CustomValidException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

}
