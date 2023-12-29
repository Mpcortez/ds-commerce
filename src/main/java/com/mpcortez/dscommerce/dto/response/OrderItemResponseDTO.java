package com.mpcortez.dscommerce.dto.response;

public record OrderItemResponseDTO(Long productId,
                                   String name,
                                   Double price,
                                   Integer quantity) {

    public Double getSubtotal() {
        return price * quantity;
    }
}
