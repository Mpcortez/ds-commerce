package com.mpcortez.dscommerce.dto.request;

public record ProductRequestDTO(Long id,
                                String name,
                                String description,
                                Double price,
                                String imgUrl) {
}
