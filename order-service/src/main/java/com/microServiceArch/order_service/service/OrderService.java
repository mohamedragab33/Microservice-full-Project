package com.microServiceArch.order_service.service;


import com.microServiceArch.order_service.dto.InventoryResponse;
import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.dto.OrderRes;
import com.microServiceArch.order_service.entity.Order;
import com.microServiceArch.order_service.entity.OrderLineItems;
import com.microServiceArch.order_service.enums.ServicesUrl;
import com.microServiceArch.order_service.mappers.OrderMapper;
import com.microServiceArch.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    private final OrderMapper orderMapper;

    public void createOrder (OrderReq orderReq){
        Order order = Order.builder()
                .orderLineItems(orderMapper.toOrderLineItems(orderReq.orderLineItemsReq()))
                .orderNumber(UUID.randomUUID().toString()).build();

      List<String> skus = order.getOrderLineItems().stream().map(OrderLineItems::getSku).toList();
         InventoryResponse[] inventoryResponses= webClient.get()
                         .uri(ServicesUrl.INVENTORY_SERVICE.getUrl(),
                                 uriBuilder -> uriBuilder.queryParam("sku-code",skus).build())
                 .retrieve().
                 bodyToMono(InventoryResponse[].class)
                 .block();


     if(inventoryResponses != null && Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock)){
         orderRepository.save(order);
         log.info("{} is Created successfully ", order.getOrderNumber());
     }else {
         log.info("{} didn't Created successfully ", order.getOrderNumber());
         throw new IllegalArgumentException("Not all element on stock ");


     }




    }
    public OrderRes getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return orderMapper.toOrderRes(order);
    }

    public List<OrderRes> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toOrderRes)
                .collect(Collectors.toList());
    }


}
