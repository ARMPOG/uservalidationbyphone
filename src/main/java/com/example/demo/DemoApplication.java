package com.example.demo;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Value("${twilio.account.sid}")
    public String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    public String AUTH_TOKEN;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
}
