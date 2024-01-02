package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.dto.response.UserResponseDTO;
import com.mpcortez.dscommerce.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends UserDetailsService {

    @Transactional(readOnly = true)
    UserResponseDTO logged();

    @Transactional(readOnly = true)
    User authenticated();
}
