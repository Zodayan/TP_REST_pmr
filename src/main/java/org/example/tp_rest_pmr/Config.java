package org.example.tp_rest_pmr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

// Classe de configuration
@Configuration
public class Config implements WebMvcConfigurer {

    // Bean gérant la configuration CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/pmr/**")
                .allowedOrigins("http://localhost:4200") // Autorisation de l'origine du client Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
