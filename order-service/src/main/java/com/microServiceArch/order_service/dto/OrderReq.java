package com.microServiceArch.order_service.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderReq(List<OrderLineItemsReq> orderLineItemsReq) {
}
