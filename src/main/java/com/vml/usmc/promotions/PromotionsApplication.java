package com.vml.usmc.promotions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.vml.usmc.events"})
public class PromotionsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PromotionsApplication.class, args);
    }
}
