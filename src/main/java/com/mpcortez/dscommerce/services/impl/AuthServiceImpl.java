package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.User;
import com.mpcortez.dscommerce.services.AuthService;
import com.mpcortez.dscommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final MessageSource messageSource;

    @Override
    public void validateSelfOrAdmin(long userId) {
        User logged = userService.authenticated();
        if (!logged.hasRole("ROLE_ADMIN") && !Objects.equals(logged.getId(), userId)) {
            throw new AccessDeniedException(getMessage());
        }
    }

    private String getMessage() {
        return messageSource.getMessage("access.denied", null, Locale.getDefault());
    }
}
