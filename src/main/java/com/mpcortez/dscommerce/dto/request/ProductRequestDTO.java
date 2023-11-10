package com.mpcortez.dscommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequestDTO(Long id,
                                @Size(min = 3, max = 80)
                                @NotBlank
                                String name,
                                @Size(min = 10, message = "O campo deve ter no mínimo 10 caracteres.")
                                String description,
                                @Positive
                                Double price,
                                String imgUrl) {
}
