package com.mpcortez.dscommerce.repositories;

import com.mpcortez.dscommerce.entities.OrderItem;
import com.mpcortez.dscommerce.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
