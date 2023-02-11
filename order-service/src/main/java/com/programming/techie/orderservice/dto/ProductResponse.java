package com.programming.techie.orderservice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String skuCode;
    private String name;
    private String description;
    private BigDecimal price;
    private String stock;
}
