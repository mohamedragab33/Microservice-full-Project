package com.microServiceArch.inventory_service.service;


import com.microServiceArch.inventory_service.dto.InventoryResponse;
import com.microServiceArch.inventory_service.respository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<String> skus){
        return inventoryRepository.findBySkuIn(skus)
                .stream()
                .map(inventory -> InventoryResponse.builder()
                .sku(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity()>0)
                        .build()).
                toList();
    }

}
