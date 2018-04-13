package com.epam.rd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.epam.rd.interceptor.AdminInterceptor;
import com.epam.rd.interceptor.AuthInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }
    
    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).addPathPatterns("/").excludePathPatterns("/login", "/registration",
                "/logout", "/er");
        
        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin");
    }

}
