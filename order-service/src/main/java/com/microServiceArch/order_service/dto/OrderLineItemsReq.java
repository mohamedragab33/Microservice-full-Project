package com.microServiceArch.order_service.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderLineItemsReq(String sku, BigDecimal price ,Integer quantity ) {
}
