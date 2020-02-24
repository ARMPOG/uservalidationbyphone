package com.example.demo.util;


import org.springframework.stereotype.Component;

@Component
public class AppUtil {

    private static final String ALPHA_NUMERIC_STRING = "0123456789";

    public String randomNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
