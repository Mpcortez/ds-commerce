package com.mpcortez.dscommerce.dto.request;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record ProductRequestDTO(Long id,
                                @Size(min = 3, max = 80)
                                @NotBlank
                                String name,
                                @Size(min = 10, message = "O campo deve ter no mínimo 10 caracteres.")
                                String description,
                                @Positive
                                @NotNull
                                Double price,
                                String imgUrl,
                                @NotEmpty
                                List<CategoryRequestDTO> categories) {

    @Override
    public List<CategoryRequestDTO> categories() {
        return Objects.requireNonNullElseGet(categories, ArrayList::new);
    }
}
