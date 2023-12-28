package com.mpcortez.dscommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CategoryResponseDTO(Long id, String name) {
}
