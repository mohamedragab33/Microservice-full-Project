package com.microServiceArch.productService.repository;

import com.microServiceArch.productService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product , String> {
}
