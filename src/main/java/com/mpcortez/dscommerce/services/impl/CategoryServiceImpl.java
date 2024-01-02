package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.Category;
import com.mpcortez.dscommerce.repositories.CategoryRepository;
import com.mpcortez.dscommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}


