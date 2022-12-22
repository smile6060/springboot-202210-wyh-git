package com.study.springboot202210wyh.repository;

import com.study.springboot202210wyh.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    //여러개 객체면 List 사용
    public List<CategoryDto> getCategories();
    public int modifyCategory(CategoryDto categoryDto);
}
