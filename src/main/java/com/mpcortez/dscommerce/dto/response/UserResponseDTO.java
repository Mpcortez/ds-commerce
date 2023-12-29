package com.mpcortez.dscommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record UserResponseDTO(Long id,
                              String name,
                              String email,
                              String phone,
                              LocalDate birthDate,
                              List<String> roles) {

    public UserResponseDTO(Long id, String name) {
        this(id, name, null, null, null, null);
    }
}
