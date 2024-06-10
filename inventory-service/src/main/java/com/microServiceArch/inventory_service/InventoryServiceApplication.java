package com.microServiceArch.inventory_service;

import com.microServiceArch.inventory_service.entity.Inventory;
import com.microServiceArch.inventory_service.respository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory item1 = Inventory.builder()
					.skuCode("SKU123")
					.quantity(100)
					.build();

			Inventory item2 = Inventory.builder()
					.skuCode("SKU124")
					.quantity(200)
					.build();

			Inventory item3 = Inventory.builder()
					.skuCode("SKU125")
					.quantity(150)
					.build();

			Inventory item4 = Inventory.builder()
					.skuCode("SKU126")
					.quantity(80)
					.build();

			Inventory item5 = Inventory.builder()
					.skuCode("SKU127")
					.quantity(50)
					.build();

			inventoryRepository.save(item1);
			inventoryRepository.save(item2);
			inventoryRepository.save(item3);
			inventoryRepository.save(item4);
			inventoryRepository.save(item5);
		};
	}

}
