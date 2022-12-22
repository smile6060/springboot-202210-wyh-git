package com.study.springboot202210wyh.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
public class CMRespDto<T> {
    private String message;
    private T data;
}
