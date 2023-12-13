package com.mpcortez.dscommerce.services;

import com.mpcortez.dscommerce.dto.response.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends UserDetailsService {

    @Transactional(readOnly = true)
    UserResponseDTO logged();
}
