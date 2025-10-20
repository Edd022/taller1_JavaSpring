package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
	@Lazy
	@Bean("experimentoConBean")
	public ExperimentBeanService experimentBeanService() {
		System.out.println("creando Bean con @Bean en AppConfig");
		return new ExperimentBeanService();
	}
}
