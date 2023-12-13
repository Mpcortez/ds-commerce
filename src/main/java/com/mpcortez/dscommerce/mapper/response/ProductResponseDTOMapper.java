package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.ProductResponseDTO;
import com.mpcortez.dscommerce.entities.Product;

public class ProductResponseDTOMapper {

    public static ProductResponseDTO mapper(Product product, boolean description) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                description ? product.getDescription() : "",
                product.getPrice(),
                product.getImgUrl()
        );
    }

    public static ProductResponseDTO mapper(Product product) {
        return mapper(product, false);
    }
}
