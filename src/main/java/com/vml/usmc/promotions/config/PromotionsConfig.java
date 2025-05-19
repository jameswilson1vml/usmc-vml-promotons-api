package com.vml.usmc.promotions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vml.usmc.promotions.service.PromotionService;

@Configuration
public class PromotionsConfig {
    @Bean
    public PromotionService setupPromotionService() {
        return new PromotionService();
    }
}
