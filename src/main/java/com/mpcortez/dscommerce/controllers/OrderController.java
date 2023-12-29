package com.mpcortez.dscommerce.controllers;

import com.mpcortez.dscommerce.dto.response.OrderResponseDTO;
import com.mpcortez.dscommerce.mapper.response.OrderResponseDTOMapper;
import com.mpcortez.dscommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService service;

    @GetMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public OrderResponseDTO findById(@PathVariable Long id) {
        return OrderResponseDTOMapper.mapper(service.findById(id));
    }
}
