package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacos9001Main {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacos9001Main.class, args);
    }
}
