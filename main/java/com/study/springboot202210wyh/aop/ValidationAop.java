package com.study.springboot202210wyh.aop;

import com.study.springboot202210wyh.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

//    앞에 있는 *는 반환자료형 모든 매소드 모든 자료형 허용한다는 거임.
//    * 모든 메소드, (..) 몇개든 상관 없음. 모든 메소드 명을 지정할 수 있다는 뜻
//    void com.study.springboot202210wyh.web.controller.account.AccountApiController.*(..))"
//    위에 꺼는 보이드를 반환하는 메소드를 실행하라임.
//    .. 컨트롤러 패키지 내에 있는 모든 하위 파일을 다 적용시키는거 이거는 패키지만 해당됨.
    @Pointcut("execution(* com.study.springboot202210wyh.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut() {}

//    메소드가 실행되기 전에 할지, 후에 할지 선택가능 @Around는 전,후 다 가능
    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult !=null) {
            if(bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                // getFieldErrors 이거 List임, List라서 forEach 가능
                bindingResult.getFieldErrors().forEach(error -> {
                    //getDefaultMessage  message = "이름은 한글만 작성 가능하며 ... 이 메세지 의미
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }

        }

//        proceedingJoinPoint.proceed() 리턴 Object로함
//        메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed();
//        메소드 호출 후 처리

        return returnValue;
    }

}

