package com.lc.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Payment8001MainApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Payment8001MainApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
