package com.epam.rd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.epam.rd.interceptor.AdminInterceptor;
import com.epam.rd.interceptor.AuthInterceptor;
import com.epam.rd.interceptor.UserAwareInterceptor;

/**
 * Конфигуратор интерсептеров. Настраивает защищаемые разделы.
 * 
 * @author Timur_Sokolov
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Бин общего интерсептера проверки наличия аутентификации
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    /**
     * Бин интерсептера проверки наличия роли ADMIN у пользователя
     */
    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    /**
     * Бин интерсептера кладущего в модель текущего пользователя
     */
    @Bean
    public UserAwareInterceptor userAwareInterceptor() {
        return new UserAwareInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/registration",
                "/logout", "/css/**", "/js/**", "/checkloginexist");

        registry.addInterceptor(userAwareInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin");
    }

}
