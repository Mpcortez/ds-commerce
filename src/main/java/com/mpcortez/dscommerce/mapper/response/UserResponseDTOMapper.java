package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.UserResponseDTO;
import com.mpcortez.dscommerce.entities.Role;
import com.mpcortez.dscommerce.entities.User;

import java.util.List;
import java.util.Set;

public class UserResponseDTOMapper {

    public static UserResponseDTO mapper(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getBirthDate(),
                rolesMapper(user.getRoles())
        );
    }

    public static UserResponseDTO mapperMin(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName()
        );
    }

    private static List<String> rolesMapper(Set<Role> roles) {
        return roles.stream().map(Role::getAuthority).toList();
    }
}
