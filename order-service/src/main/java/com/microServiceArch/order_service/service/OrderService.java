package com.microServiceArch.order_service.service;


import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.dto.OrderRes;
import com.microServiceArch.order_service.entity.Order;
import com.microServiceArch.order_service.mappers.OrderMapper;
import com.microServiceArch.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void createOrder (OrderReq orderReq){
        Order order = Order.builder()
                .orderLineItems(orderMapper.toOrderLineItems(orderReq.orderLineItemsReq()))
                .orderNumber(UUID.randomUUID().toString()).build();
        orderRepository.save(order);
        log.info("{} is Created successfully ", order.getOrderNumber());
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
