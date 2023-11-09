package com.mpcortez.dscommerce.mapper.request;

import com.mpcortez.dscommerce.dto.request.ProductRequestDTO;
import com.mpcortez.dscommerce.entities.Product;

public class ProductRequestDTOMapper {

    public static Product mapper(ProductRequestDTO dto) {
        return Product.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .imgUrl(dto.imgUrl())
                .build();
    }
}
