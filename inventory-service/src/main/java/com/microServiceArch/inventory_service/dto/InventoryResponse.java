package com.microServiceArch.inventory_service.dto;

import lombok.Builder;

@Builder
public record InventoryResponse(String sku, boolean isInStock) {
}
