package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.dto.request.OrderRequestDTO;
import com.mpcortez.dscommerce.entities.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional(readOnly = true)
    Order findById(Long id);

    @Transactional()
    Order insert(OrderRequestDTO orderRequest);
}
