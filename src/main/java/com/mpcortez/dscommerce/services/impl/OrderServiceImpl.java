package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.dto.request.OrderItemRequestDTO;
import com.mpcortez.dscommerce.dto.request.OrderRequestDTO;
import com.mpcortez.dscommerce.entities.Order;
import com.mpcortez.dscommerce.mapper.request.OrderItemRequestDTOMapper;
import com.mpcortez.dscommerce.mapper.request.OrderRequestDTOMapper;
import com.mpcortez.dscommerce.repositories.OrderRepository;
import com.mpcortez.dscommerce.services.*;
import com.mpcortez.dscommerce.services.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    private final AuthService authService;

    private final UserService userService;

    private final OrderItemService orderItemService;

    private final ProductService productService;

    private final MessageSource messageSource;

    @Override
    public Order findById(Long id) {
        var order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(getMessage(String.valueOf(id))));
        authService.validateSelfOrAdmin(order.getClient().getId());
        return order;
    }

    @Override
    public Order insert(OrderRequestDTO orderRequest) {
        var order = OrderRequestDTOMapper.mapper(userService.authenticated());
        handleRequestItems(orderRequest.items(), order);

        repository.save(order);
        orderItemService.insertAll(order.getItems());

        return order;
    }

    private void handleRequestItems(List<OrderItemRequestDTO> itemsRequest, Order order) {
        itemsRequest.forEach(itemRequest -> {
            var product = productService.getReferenceById(itemRequest.productId());
            order.getItems().add(OrderItemRequestDTOMapper.mapper(order, product, itemRequest.quantity()));
        });
    }

    private String getMessage(String... args) {
        return messageSource.getMessage("order.not.found", args, Locale.getDefault());
    }
}
