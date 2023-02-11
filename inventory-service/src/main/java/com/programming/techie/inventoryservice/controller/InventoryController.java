package com.programming.techie.inventoryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.inventoryservice.dto.InventoryResponse;
import com.programming.techie.inventoryservice.dto.OrderLineItemsDto;
import com.programming.techie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
     
    private final InventoryService inventoryService;

    @PostMapping
   public List<InventoryResponse> isInStock(@RequestBody List<OrderLineItemsDto> orderItems){
        return inventoryService.isInStock(orderItems);
   }
}
