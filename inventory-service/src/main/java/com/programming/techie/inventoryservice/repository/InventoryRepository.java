package com.programming.techie.inventoryservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.programming.techie.inventoryservice.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String>{
    List<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
