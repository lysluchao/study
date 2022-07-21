package com.lc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaMain7001.class,args);
    }
}
