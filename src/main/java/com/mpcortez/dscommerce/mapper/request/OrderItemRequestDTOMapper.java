package com.mpcortez.dscommerce.mapper.request;

import com.mpcortez.dscommerce.entities.Order;
import com.mpcortez.dscommerce.entities.OrderItem;
import com.mpcortez.dscommerce.entities.Product;

public class OrderItemRequestDTOMapper {

    public static OrderItem mapper(Order order, Product product, Integer quantity) {
        return new OrderItem(order, product, quantity, product.getPrice());
    }
}
