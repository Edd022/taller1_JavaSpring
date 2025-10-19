package com.acmspring.co.punto2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration
public class AppConfig {
    @Bean
    @Scope(SCOPE_SINGLETON)
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}