package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentSentinel9007Main {
    public static void main(String[] args) {
        SpringApplication.run(PaymentSentinel9007Main.class, args);
    }
}
