package com.mpcortez.dscommerce.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CustomAdviceError(Instant timestamp, Integer status, String path, String error,
                                List<ValidationFieldError> fieldErrors
) {

    public CustomAdviceError(Integer status, String path, String error) {
        this(Instant.now(), status, path, error, new ArrayList<>());
    }

    public CustomAdviceError(Integer status, String path) {
        this(Instant.now(), status, path, null, new ArrayList<>());
    }

    public void addFieldErrors(String fieldName, String errorMessage) {
        fieldErrors.add(new ValidationFieldError(fieldName, errorMessage));
    }
}
