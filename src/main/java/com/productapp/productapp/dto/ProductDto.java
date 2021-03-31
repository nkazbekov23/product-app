package com.productapp.productapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDto {

    private int id;

    private Long version;

    private LocalDateTime localDateTime;

    private String title;

    private String ups;

    private BigDecimal price;
}
