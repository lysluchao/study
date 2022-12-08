package com.lc.bedc.controller;

import com.lc.bedc.service.BedcSpdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 浦发理财测试
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/20 10:24
 */
@RestController
@RequestMapping("/spd")
@Slf4j
public class SpdFinanceController {
    private BedcSpdService bedcSpdService;

    @Autowired
    public void setBedcSpdService(BedcSpdService bedcSpdService) {
        this.bedcSpdService = bedcSpdService;
    }

    @PostMapping(value = "/test")
    public String test(@RequestBody String s) {
        try {
            String msg = URLDecoder.decode(s, "GBK");
            log.info("收到请求:{}", msg);
            msg = msg.substring(msg.indexOf("<?xml"));
            return bedcSpdService.test(msg);
        } catch (UnsupportedEncodingException e) {
            log.error("报文错误{}", e.getMessage());
            return null;
        }
    }



}
