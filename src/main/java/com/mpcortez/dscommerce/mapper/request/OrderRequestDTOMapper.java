package com.mpcortez.dscommerce.mapper.request;

import com.mpcortez.dscommerce.entities.Order;
import com.mpcortez.dscommerce.entities.User;
import com.mpcortez.dscommerce.enums.OrderStatus;

import java.time.Instant;
import java.util.HashSet;

public class OrderRequestDTOMapper {

    public static Order mapper(User user) {
        return Order.builder()
                .moment(Instant.now())
                .client(user)
                .status(OrderStatus.WAITING_PAYMENT)
                .items(new HashSet<>())
                .build();
    }
}
