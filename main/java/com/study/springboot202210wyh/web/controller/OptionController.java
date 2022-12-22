package com.study.springboot202210wyh.web.controller;

import com.study.springboot202210wyh.service.OptionService;
import com.study.springboot202210wyh.web.dto.CategoryDto;
import com.study.springboot202210wyh.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto);

        return ResponseEntity
                .created(URI.create("/api/option/category/" + optionService.addOption(categoryDto)))
                .body(categoryDto);
    }

        @GetMapping("/categories")
        public ResponseEntity<?> getCategory() {

            return ResponseEntity.ok(optionService.getCategories());
        }

        @PutMapping("/category/{categoryId}")
        public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
            optionService.modifyCategory(categoryId, categoryDto);
            return ResponseEntity.ok(true);
    }


}

// 카테고리 하나 지정해서 만들기
// 유저는 유저들로 해서 만들어보기