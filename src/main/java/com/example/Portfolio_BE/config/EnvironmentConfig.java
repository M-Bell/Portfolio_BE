package com.example.Portfolio_BE.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EnvironmentConfig {

    public static Map params = ObjectUtils.asMap(
            "use_filename", true,
            "unique_filename", false,
            "overwrite", true
    );

    @Value("${cloudinary.url}")
    private String cloudinaryUrl;


    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(cloudinaryUrl);
        cloudinary.config.secure = true;
        return cloudinary;
    }
}
