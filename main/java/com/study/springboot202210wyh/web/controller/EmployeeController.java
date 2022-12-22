package com.study.springboot202210wyh.web.controller;

import com.study.springboot202210wyh.service.EmployeeService;
import com.study.springboot202210wyh.web.dto.CMRespDto;
import com.study.springboot202210wyh.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(employeeDto)));

    }

}
