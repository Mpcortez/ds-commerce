package com.mpcortez.dscommerce.controllers;

import com.mpcortez.dscommerce.dto.request.ProductRequestDTO;
import com.mpcortez.dscommerce.dto.response.ProductResponseDTO;
import com.mpcortez.dscommerce.mapper.request.ProductRequestDTOMapper;
import com.mpcortez.dscommerce.mapper.response.ProductResponseDTOMapper;
import com.mpcortez.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    @GetMapping(value = "{id}")
    public ProductResponseDTO findById(@PathVariable Long id) {
        return ProductResponseDTOMapper.mapper(service.findById(id));
    }

    @GetMapping()
    public Page<ProductResponseDTO> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                            Pageable pageable) {
        return service.findAll(name, pageable).map(ProductResponseDTOMapper::mapper);
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDTO> insert(@RequestBody @Valid ProductRequestDTO dto) {
        var responseDTO = ProductResponseDTOMapper.mapper(service.insert(ProductRequestDTOMapper.mapper(dto)));
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(responseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ProductResponseDTO update(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO dto) {
        return ProductResponseDTOMapper.mapper(service.update(id, ProductRequestDTOMapper.mapper(dto)));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
