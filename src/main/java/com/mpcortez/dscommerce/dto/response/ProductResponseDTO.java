package com.mpcortez.dscommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ProductResponseDTO(Long id, String name, String description, Double price, String imgUrl) {
}
