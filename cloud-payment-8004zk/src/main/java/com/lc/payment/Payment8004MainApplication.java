package com.lc.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004MainApplication.class,args);
    }
}