package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {

   @Transactional(readOnly = true)
   Product findById(Long id);

   @Transactional(readOnly = true)
   Page<Product> findAll(String name, Pageable pageable);

   @Transactional()
   Product insert(Product product);

   @Transactional()
   Product update(Long id, Product product);

   @Transactional(propagation = Propagation.SUPPORTS)
   void delete(Long id);
}
