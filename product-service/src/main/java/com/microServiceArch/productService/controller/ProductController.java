package com.microServiceArch.productService.controller;

import com.microServiceArch.productService.dto.ProductReq;
import com.microServiceArch.productService.dto.ProductRes;
import com.microServiceArch.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductReq productReq) {
        productService.createProduct(productReq);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRes> getAllProducts(){
        return  productService.getAllProducts();
    }




}
