package com.mpcortez.dscommerce.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
       super(message);
    }
}
