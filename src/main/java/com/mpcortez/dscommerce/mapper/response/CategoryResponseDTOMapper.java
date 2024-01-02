package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.CategoryResponseDTO;
import com.mpcortez.dscommerce.entities.Category;

import java.util.List;
import java.util.Set;

public class CategoryResponseDTOMapper {

    public static CategoryResponseDTO mapper(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName());
    }

    public static List<CategoryResponseDTO> mapper(Set<Category> categories) {
        return categories.stream()
                .map(CategoryResponseDTOMapper::mapper)
                .toList();
    }
}
