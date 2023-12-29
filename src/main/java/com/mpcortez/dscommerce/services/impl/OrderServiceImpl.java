package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.Order;
import com.mpcortez.dscommerce.repositories.OrderRepository;
import com.mpcortez.dscommerce.services.OrderService;
import com.mpcortez.dscommerce.services.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    private final MessageSource messageSource;

    @Override
    public Order findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage(String.valueOf(id))));
    }

    private String getMessage(String... args) {
        return messageSource.getMessage("order.not.found", args, Locale.getDefault());
    }
}
