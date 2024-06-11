package com.microServiceArch.order_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record InventoryResponse(String sku, boolean isInStock) {
}
