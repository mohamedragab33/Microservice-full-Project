package com.microServiceArch.inventory_service.controller;


import com.microServiceArch.inventory_service.dto.InventoryResponse;
import com.microServiceArch.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService ;


    @GetMapping()
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam(name = "sku-code") List<String> skuCodes){
       return new ResponseEntity<>(inventoryService.isInStock(skuCodes) ,HttpStatus.OK);
    }
}
