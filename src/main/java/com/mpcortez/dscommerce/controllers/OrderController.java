package com.mpcortez.dscommerce.controllers;

import com.mpcortez.dscommerce.dto.request.OrderRequestDTO;
import com.mpcortez.dscommerce.dto.response.OrderResponseDTO;
import com.mpcortez.dscommerce.mapper.response.OrderResponseDTOMapper;
import com.mpcortez.dscommerce.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;

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

    @PostMapping()
    @ResponseStatus(CREATED)
    @PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    public ResponseEntity<OrderResponseDTO> insert(@RequestBody @Valid OrderRequestDTO dto) {
        var responseDTO = OrderResponseDTOMapper.mapper(service.insert((dto)));
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(responseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }
}
