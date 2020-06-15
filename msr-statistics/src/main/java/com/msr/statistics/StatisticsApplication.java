package com.msr.statistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lv
 * @version V1.0
 * @Package com.msr.statistics
 * @date 2020/6/12 11:45
 * @Copyright © MSR
 */
@EnableFeignClients(basePackages = "com.msr.statistics.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.msr.statistics.mapper")
@ComponentScan(basePackages={"com.msr.statistics","com.msr.common"})
public class StatisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class,args);
    }
}
