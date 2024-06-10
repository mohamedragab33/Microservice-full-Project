package com.microServiceArch.order_service.controllers;


import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.dto.OrderRes;
import com.microServiceArch.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OderController {

    private final OrderService orderService ;
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderReq orderReq){
        orderService.createOrder(orderReq);
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity<List<OrderRes>> getAllOrders() {
        List<OrderRes> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderRes> getOrderById(@PathVariable Long orderId) {
        OrderRes order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
