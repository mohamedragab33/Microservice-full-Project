package com.microServiceArch.inventory_service.respository;

import com.microServiceArch.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    List<Inventory> findBySkuIn(List<String> skus);
}
