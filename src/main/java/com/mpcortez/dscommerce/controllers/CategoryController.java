package com.mpcortez.dscommerce.controllers;

import com.mpcortez.dscommerce.dto.response.CategoryResponseDTO;
import com.mpcortez.dscommerce.mapper.response.CategoryResponseDTOMapper;
import com.mpcortez.dscommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping()
    public List<CategoryResponseDTO> findAll() {
        return service.findAll().stream().map(CategoryResponseDTOMapper::mapper).toList();
    }
}
