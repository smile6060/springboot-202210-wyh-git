package com.study.springboot202210wyh.web.dto;


import lombok.*;

@Setter
@Getter
@ToString
public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;
}
