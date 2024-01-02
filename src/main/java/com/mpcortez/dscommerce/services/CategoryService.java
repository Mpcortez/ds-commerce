package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.entities.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {

    @Transactional(readOnly = true)
    List<Category> findAll();
}
