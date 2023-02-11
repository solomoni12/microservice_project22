package com.programming.techie.orderservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    @Id
    private String id;
    
    @Indexed(unique=true)
    private String orderNumber;

    private String accountId;

    private List<OrderLineItems> orderLineItemsList;    
}
