package com.mpcortez.dscommerce.repositories;

import com.mpcortez.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
