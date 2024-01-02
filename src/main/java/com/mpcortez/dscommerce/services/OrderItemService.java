package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.entities.OrderItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface OrderItemService {
    @Transactional
    void insertAll(Set<OrderItem> items);
}
