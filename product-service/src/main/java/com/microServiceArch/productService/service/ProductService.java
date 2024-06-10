package com.microServiceArch.productService.service;

import com.microServiceArch.productService.dto.ProductReq;
import com.microServiceArch.productService.dto.ProductRes;
import com.microServiceArch.productService.entity.Product;
import com.microServiceArch.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductReq productReq){

        Product product = Product.builder().
                name(productReq.getName())
                .price(productReq.getPrice())
                .description(productReq.getDescription())
                .build();
        var savedProduct =  productRepository.save(product);
        log.info("product {} created successfully" , savedProduct.getId());
    }


    public List<ProductRes> getAllProducts() {
       var products =  productRepository.findAll();
       return products.stream().map(this::productToProductRes).toList();
    }

    private ProductRes productToProductRes(Product product) {
        return ProductRes.builder().Id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .name(product.getName())
                .build();
    }
}
