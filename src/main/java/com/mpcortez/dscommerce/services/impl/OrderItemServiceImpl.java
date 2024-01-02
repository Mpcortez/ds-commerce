package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.OrderItem;
import com.mpcortez.dscommerce.repositories.OrderItemRepository;
import com.mpcortez.dscommerce.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    @Override
    public void insertAll(Set<OrderItem> items) {
        repository.saveAll(items);
    }
}
