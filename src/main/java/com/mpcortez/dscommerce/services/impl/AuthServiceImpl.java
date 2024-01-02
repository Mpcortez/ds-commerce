package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.User;
import com.mpcortez.dscommerce.services.AuthService;
import com.mpcortez.dscommerce.services.MessageService;
import com.mpcortez.dscommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final MessageService messageService;

    @Override
    public void validateSelfOrAdmin(long userId) {
        User logged = userService.authenticated();
        if (!logged.hasRole("ROLE_ADMIN") && !Objects.equals(logged.getId(), userId)) {
            throw new AccessDeniedException(messageService.getMessage("access.denied"));
        }
    }
}
