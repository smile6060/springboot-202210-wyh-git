package com.study.springboot202210wyh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    // @RequestMapping(value = "/page1", method = RequestMethod.GET) 같은거임 GetMapping
    @GetMapping("/page1")
//    public String page1() {
//        return "page1";
//    } 밑에꺼랑 같은의미임
    public ModelAndView page1() {
        ModelAndView mav = new ModelAndView();
            mav.setViewName("page1");
            mav.addObject("key", "value");
            return mav;
        }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

}
