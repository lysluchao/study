package com.lc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/order/payment/nacos/{id}")
    public String paymentInfo(@PathVariable Long id) {
        List<String> services = discoveryClient.getServices();
        String s = services.get(0);
        List<ServiceInstance> instances = discoveryClient.getInstances(s);
        return restTemplate.getForObject("http://payment-nacos/payment/nacos/"+id, String.class);
    }
}
