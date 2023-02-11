package com.programming.techie.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.programming.techie.inventoryservice.model.Inventory;
import com.programming.techie.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("y7y6t6");
			// inventory.setQuantity(5);

			// Inventory inventory1 = new Inventory();
			// inventory1.setSkuCode("iphone");
			// inventory1.setQuantity(0);

			// inventoryRepository.save(inventory);
			// inventoryRepository.save(inventory1);
		};
	}

}
