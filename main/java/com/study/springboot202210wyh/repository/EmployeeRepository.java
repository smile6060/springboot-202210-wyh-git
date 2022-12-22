package com.study.springboot202210wyh.repository;

import com.study.springboot202210wyh.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getEmployees();
    public int modifyEmployee(EmployeeDto employeeDto);
}
