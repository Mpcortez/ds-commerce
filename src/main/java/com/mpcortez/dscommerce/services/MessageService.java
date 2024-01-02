package com.mpcortez.dscommerce.services;

public interface MessageService {

    default String getMessage(String code) {
        return getMessage(code, "");
    }

    String getMessage(String code, String... args);
}
