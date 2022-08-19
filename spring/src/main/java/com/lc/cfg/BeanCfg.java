package com.lc.cfg;

import com.lc.common.entities.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Description: 配置类
 * @Auther: LuChao
 * @Date: 2022/8/19 14:58
 * @Version: v1.0
 */
@Configuration
public class BeanCfg {
    @PostConstruct
    public void beanCfgPost() {
        System.out.println("====================beanCfgPost");
    }

    @Bean
    public Payment c() {
        System.out.println(2222+"222221weqweewq");
        return new Payment(1L, "21312");
    }
}
