package com.mpcortez.dscommerce.repositories;

import com.mpcortez.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
