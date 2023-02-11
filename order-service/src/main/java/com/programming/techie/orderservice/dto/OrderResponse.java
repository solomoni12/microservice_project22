package com.programming.techie.orderservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String accountId;
    
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
