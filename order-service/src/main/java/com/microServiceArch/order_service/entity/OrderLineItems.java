package com.microServiceArch.order_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sku ;
    private BigDecimal price ;
    private Integer quantity ;
}
