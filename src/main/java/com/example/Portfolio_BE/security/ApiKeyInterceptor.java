package com.example.Portfolio_BE.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER_NAME = "X-API-KEY";
    @Value("${api.key}")
    private String apiKey;


    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // Allow public GET requests without API key
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // Check for the API key in other requests (POST, PUT, DELETE)
        String retrievedApiKey = request.getHeader(API_KEY_HEADER_NAME);

        // Validate the API key
        if (apiKey.equals(retrievedApiKey)) {
            return true;  // Valid API key
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Missing or invalid API key");
            return false;
        }
    }
}