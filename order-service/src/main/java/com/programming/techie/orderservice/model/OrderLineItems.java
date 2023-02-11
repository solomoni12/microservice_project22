package com.programming.techie.orderservice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
