package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.dto.response.UserResponseDTO;
import com.mpcortez.dscommerce.entities.Role;
import com.mpcortez.dscommerce.entities.User;
import com.mpcortez.dscommerce.mapper.response.UserResponseDTOMapper;
import com.mpcortez.dscommerce.repositories.UserRepository;
import com.mpcortez.dscommerce.services.UserService;
import com.mpcortez.dscommerce.services.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final MessageSource messageSource;

    @Override
    public UserResponseDTO logged() {
        return UserResponseDTOMapper.mapper(authenticated());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = findByEmail(username);

        return User.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(getAuthorities(user))
                .build();
    }

    @Transactional(readOnly = true)
    protected User findByEmail(String email) {
        return repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException(getMessage(email)));
    }

    protected Set<Role> getAuthorities(User user) {
        return user.getAuthorities()
                .stream()
                .map(role -> Role.builder()
                        .authority(role.getAuthority())
                        .build())
                .collect(Collectors.toSet());
    }

    protected User authenticated() {
        String username = "";

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Jwt principal = (Jwt) auth.getPrincipal();
            username = principal.getClaim("username");

            return findByEmail(username);
        } catch (Exception e) {
            throw new ResourceNotFoundException(getMessage(username));
        }
    }

    private String getMessage(String... args) {
        return messageSource.getMessage("user.not.found", args, Locale.getDefault());
    }
}
