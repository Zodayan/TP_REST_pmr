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
// Annotation @Configuration : Cette classe est utilisée pour la configuration Spring de l'application.
@Configuration
public class Config implements WebMvcConfigurer {

    // Méthode addCorsMappings permet de configurer les règles CORS pour l'application
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // Applique les configurations CORS à toutes les routes ("/**")
        registry.addMapping("/**")
                // Autorise uniquement les requêtes provenant de l'origine spécifiée (ici, le front-end Angular sur localhost:4200)
                .allowedOrigins("http://localhost:4200") // Remplacez par l'URL du front-end si nécessaire
                // Permet uniquement certaines méthodes HTTP pour les requêtes CORS
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // Permet tous les en-têtes dans les requêtes CORS
                .allowedHeaders("*")
                // Permet d'envoyer des informations de connexion ou des cookies avec les requêtes (utile pour l'authentification)
                .allowCredentials(true);
    }
}
