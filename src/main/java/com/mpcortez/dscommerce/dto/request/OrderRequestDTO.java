package com.mpcortez.dscommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record OrderRequestDTO(@NotEmpty List<OrderItemRequestDTO> items) {

    @Override
    public List<OrderItemRequestDTO> items() {
        return Objects.requireNonNullElseGet(items, ArrayList::new);
    }
}
