package com.microServiceArch.inventory_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public record InventoryResponse(String sku, boolean isInStock) {
}
