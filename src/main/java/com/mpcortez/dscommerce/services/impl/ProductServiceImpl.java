package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.Product;
import com.mpcortez.dscommerce.repositories.ProductRepository;
import com.mpcortez.dscommerce.services.MessageService;
import com.mpcortez.dscommerce.services.ProductService;
import com.mpcortez.dscommerce.services.exception.DatabaseException;
import com.mpcortez.dscommerce.services.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final MessageService messageService;

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageService.getMessage("product.not.found", String.valueOf(id))));
    }

    @Override
    public Product getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Page<Product> findAll(String name, Pageable pageable) {
        return repository.searchByName(name, pageable);
    }

    @Override
    public Product insert(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        existsById(id);
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        existsById(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(messageService.getMessage("product.delete.error", String.valueOf(id)));
        }
    }

    private void existsById(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(messageService.getMessage("product.not.found", String.valueOf(id)));
    }
}
