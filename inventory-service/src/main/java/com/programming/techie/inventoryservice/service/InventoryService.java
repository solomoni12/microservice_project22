package com.programming.techie.inventoryservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programming.techie.inventoryservice.dto.InventoryResponse;
import com.programming.techie.inventoryservice.dto.OrderLineItemsDto;
import com.programming.techie.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

        @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<OrderLineItemsDto> orderItems){

        List<InventoryResponse> inventoryResponses = new ArrayList<>();
        for(OrderLineItemsDto order: orderItems) {
            InventoryResponse inventory = new InventoryResponse();
            var result = inventoryRepository.findBySkuCode(order.getSkuCode());
            inventory.setSkuCode(result.get(0).getSkuCode());
            inventory.setInStock(result.get(0).getQuantity() >= order.getQuantity());
            inventoryResponses.add(inventory);
        }

        return inventoryResponses;
    }
}
