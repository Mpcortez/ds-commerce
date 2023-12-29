package com.mpcortez.dscommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mpcortez.dscommerce.enums.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderResponseDTO(Long id,
                               Instant moment,
                               OrderStatus status,
                               UserResponseDTO client,
                               @JsonInclude(JsonInclude.Include.NON_EMPTY)
                               PaymentResponseDTO payment,
                               List<OrderItemResponseDTO> items) {

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemResponseDTO item : items) {
            sum += item.getSubtotal();
        }
        return sum;
    }
}
