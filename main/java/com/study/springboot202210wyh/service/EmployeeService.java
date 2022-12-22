package com.study.springboot202210wyh.service;

import com.study.springboot202210wyh.repository.EmployeeRepository;
import com.study.springboot202210wyh.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmployeeDto employeeDto) {
        return employeeRepository.saveEmployee(employeeDto) > 0 ? employeeDto.getEmpId() : 0;
        // 0보다 크면 getEmpId 리턴을 할거고 그렇지 않으면 ???
    }


}
