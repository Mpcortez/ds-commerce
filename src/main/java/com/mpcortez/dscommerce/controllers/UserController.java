package com.mpcortez.dscommerce.controllers;

import com.mpcortez.dscommerce.dto.response.UserResponseDTO;
import com.mpcortez.dscommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService service;

    @GetMapping(value = "logged")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public UserResponseDTO logged() {
        return service.logged();
    }
}
