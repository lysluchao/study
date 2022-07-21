package com.lc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lc.common.entities.CommonResult;
import com.lc.common.entities.Payment;
import com.lc.handler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    public String testA() {
        return "test A";
    }

    @GetMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "testB");
        return "test B";
    }

    @GetMapping("testD")
    public String testD() throws InterruptedException {
        Thread.sleep((long) (1000 * Math.random()));
        log.info(Thread.currentThread().getName() + "\t" + "testD RT");
        return "test D";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHostKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey";
    }

    public String dealTestHotKey(String p1,String p2, BlockException blockException) {
        return "dealTestHotKey/(ㄒoㄒ)/~~";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流",new Payment(2020L,"serial"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t"+"服务不可用",null);
    }


    @GetMapping("/customerHandler")
    @SentinelResource(value = "customerHandler",blockHandlerClass = CustomerHandler.class,blockHandler = "handlerException1")
    public CommonResult customerHandler(){
        return new CommonResult(200,"customerHandler",null);
    }
}
