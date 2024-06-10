package com.microServiceArch.order_service.dto;

import java.math.BigDecimal;

public record OrderLineItemsRes(String sku, BigDecimal price, Integer quantity) {}
