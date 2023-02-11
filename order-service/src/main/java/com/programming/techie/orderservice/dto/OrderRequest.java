package com.programming.techie.orderservice.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String accountId;
    
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
