package com.mpcortez.dscommerce.mapper.request;

import com.mpcortez.dscommerce.dto.request.CategoryRequestDTO;
import com.mpcortez.dscommerce.entities.Category;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryRequestDTOMapper {

    public static Set<Category> mapper(List<CategoryRequestDTO> categoriesRequest) {
        return categoriesRequest.stream()
                .map(catRequest -> Category.builder()
                        .id(catRequest.id())
                        .build())
                .collect(Collectors.toSet());
    }
}
