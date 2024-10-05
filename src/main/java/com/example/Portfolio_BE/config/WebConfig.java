package com.example.Portfolio_BE.config;

import com.example.Portfolio_BE.security.ApiKeyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ApiKeyInterceptor apiKeyInterceptor;

    @Autowired
    public WebConfig(ApiKeyInterceptor apiKeyInterceptor) {
        this.apiKeyInterceptor = apiKeyInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiKeyInterceptor)
                .addPathPatterns("/api/**");  // Apply to all API routes
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Allow CORS for /api/ paths
                .allowedOrigins("https://portfolio-fe-fn9m.onrender.com", "http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

