package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacos83Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacos83Main.class,args);
    }
}
