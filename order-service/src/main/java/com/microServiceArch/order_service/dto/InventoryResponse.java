package com.microServiceArch.order_service.dto;

import lombok.Builder;

@Builder
public record InventoryResponse(String sku, boolean isInStock) {
}
