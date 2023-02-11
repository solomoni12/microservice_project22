package com.programming.techie.orderservice.service;
  
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.programming.techie.orderservice.dto.InventoryResponse;
import com.programming.techie.orderservice.dto.OrderLineItemsDto;
import com.programming.techie.orderservice.dto.OrderRequest;
// import com.programming.techie.orderservice.dto.OrderResponse;
import com.programming.techie.orderservice.model.Order;
import com.programming.techie.orderservice.model.OrderLineItems;
import com.programming.techie.orderservice.repository.OrderRepository;


import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setAccountId(orderRequest.getAccountId());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        // call inventory sercive and place order if is in stock
        InventoryResponse[] inventoryResponsesArray = webClient.post()
                .uri("http://localhost:8080/api/inventory")
                .body(BodyInserters.fromValue(orderLineItems))
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
                .allMatch(InventoryResponse::isInStock);
        
        System.out.println(Arrays.stream(inventoryResponsesArray).toList());

        if(allProductsInStock){
            orderRepository.save(order);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                 "Product is not in stock, Please try again later");
        }
        
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

    // function to get Data from database
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
