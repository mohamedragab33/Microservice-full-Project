package com.microServiceArch.order_service.dto;


import lombok.Builder;

import java.util.List;

@Builder
public record OrderRes(Long id, String orderNumber, List<OrderLineItemsRes> orderLineItems) {}

