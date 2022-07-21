package com.lc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Order80OpenFeignMain {

    public static void main(String[] args) {
        SpringApplication.run(Order80OpenFeignMain.class,args);
    }
}
