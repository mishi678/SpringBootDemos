package com.mishi.controller;

import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * creating class by implementing functional interface
 * invoke by
 * http://localhost:8080/helloo/{inputString}
 *
 * Also note than for scan this package we need to add a property
 * in application.properties
 *
 * spring.cloud.function.scan.packages=com.mishi.controller
 *
 */
public class Helloo implements Function<String,String> {
    @Override
    public String apply(String pathParam) {
        return "Hello " + pathParam;
    }
}
