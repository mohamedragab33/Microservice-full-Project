package com.microServiceArch.inventory_service.service;


import com.microServiceArch.inventory_service.respository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Boolean isInStock(String sku){

        return inventoryRepository.findBySkuCode(sku).isPresent();
    }

}
