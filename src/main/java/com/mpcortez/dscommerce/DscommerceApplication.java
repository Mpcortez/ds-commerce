package com.mpcortez.dscommerce;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class DscommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DscommerceApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
