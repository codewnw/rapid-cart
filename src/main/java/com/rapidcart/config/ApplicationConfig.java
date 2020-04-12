package com.rapidcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.rapidcart")
@Import({ SpringMvcConfig.class, SpringHibernateConfig.class, SpringAopConfig.class })
@PropertySource("classpath:rapidcart.properties")
public class ApplicationConfig {

}
