package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.entities.Role;
import com.mpcortez.dscommerce.entities.User;
import com.mpcortez.dscommerce.repositories.UserRepository;
import com.mpcortez.dscommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User authenticateByEmail(String email) {
        return repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = authenticateByEmail(username);

        return User.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(getAuthorities(user))
                .build();
    }

    private Set<Role> getAuthorities(User user) {
        return user.getAuthorities()
                .stream()
                .map(role -> Role.builder()
                        .authority(role.getAuthority())
                        .build())
                .collect(Collectors.toSet());
    }
}
