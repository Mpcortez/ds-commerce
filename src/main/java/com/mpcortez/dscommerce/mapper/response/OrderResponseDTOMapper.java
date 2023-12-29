package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.OrderResponseDTO;
import com.mpcortez.dscommerce.entities.Order;

public class OrderResponseDTOMapper {

    public static OrderResponseDTO mapper(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getMoment(),
                order.getStatus(),
                UserResponseDTOMapper.mapperMin(order.getClient()),
                PaymentResponseDTOMapper.mapper(order.getPayment()),
                OrderItemResponseDTOMapper.mapper(order.getItems())
        );
    }
}
