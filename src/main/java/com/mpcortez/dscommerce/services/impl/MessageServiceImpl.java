package com.mpcortez.dscommerce.services.impl;

import com.mpcortez.dscommerce.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
