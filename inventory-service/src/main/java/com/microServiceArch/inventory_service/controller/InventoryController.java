package com.microServiceArch.inventory_service.controller;


import com.microServiceArch.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService ;


    @GetMapping("/{sku-code}")
    public ResponseEntity<Boolean> isInStock(@PathVariable(name = "sku-code") String skuCode){
       return new ResponseEntity<>(inventoryService.isInStock(skuCode) ,HttpStatus.OK);
    }





}
