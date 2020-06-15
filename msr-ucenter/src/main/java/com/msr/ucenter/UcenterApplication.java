package com.msr.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lv
 * @version V1.0
 * @Package com.msr.ucenter
 * @date 2020/6/12 10:41
 * @Copyright © MSR
 */
@EnableDiscoveryClient
@MapperScan("com.msr.ucenter.mapper")
@ComponentScan(basePackages={"com.msr.ucenter","com.msr.common"})
@SpringBootApplication
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class,args);
    }
}
