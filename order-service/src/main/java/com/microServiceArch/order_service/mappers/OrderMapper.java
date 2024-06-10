package com.microServiceArch.order_service.mappers;


import com.microServiceArch.order_service.dto.OrderLineItemsReq;
import com.microServiceArch.order_service.dto.OrderLineItemsRes;
import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.dto.OrderRes;
import com.microServiceArch.order_service.entity.Order;
import com.microServiceArch.order_service.entity.OrderLineItems;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

//    @Mapping(source = "orderLineItemsReq" , target = "orderLineItems")
//     Order toOrder (OrderReq orderReq);


    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderRes toOrderRes(Order order);

    OrderLineItemsRes toOrderLineItemsRes(OrderLineItems orderLineItems);

    @Mapping(target = "id" , ignore = true)
    @Named("toOrderLineItem")
    OrderLineItems toOrderLineItem (OrderLineItemsReq orderLineItemReq);

    @IterableMapping(qualifiedByName = "toOrderLineItem")
    List<OrderLineItems> toOrderLineItems(List<OrderLineItemsReq> orderLineItemsReq);

}
