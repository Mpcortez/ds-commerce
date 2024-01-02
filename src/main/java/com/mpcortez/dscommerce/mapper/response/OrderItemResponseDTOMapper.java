package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.OrderItemResponseDTO;
import com.mpcortez.dscommerce.entities.OrderItem;

import java.util.List;
import java.util.Set;

public class OrderItemResponseDTOMapper {

    public static List<OrderItemResponseDTO> mapper(Set<OrderItem> items) {
        return items.stream()
                .map(item -> new OrderItemResponseDTO(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getPrice(),
                        item.getQuantity(),
                        item.getProduct().getImgUrl()
                ))
                .toList();
    }
}
