package com.study.springboot202210wyh.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    // view reserve 뷰리절브한테
    @GetMapping("/account/register")
    public String loadRegister() {
        return "account/register";
    }
}
