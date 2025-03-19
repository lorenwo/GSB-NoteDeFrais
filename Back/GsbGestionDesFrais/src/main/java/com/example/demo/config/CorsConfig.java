package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // 🌍 Autoriser toutes les origines (ou spécifier localhost:4200 si nécessaire)
        config.setAllowedOriginPatterns(List.of("*"));
        
        // 🛠️ Autoriser toutes les méthodes HTTP
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // 📥 Autoriser tous les headers
        config.setAllowedHeaders(List.of("*"));
        
        // 🔓 Autoriser l'envoi de credentials (cookies, headers d'authentification, etc.)
        config.setAllowCredentials(true);
        
        // 🖥️ Exposer les headers personnalisés dans la réponse (si nécessaire)
        config.setExposedHeaders(List.of("Authorization", "Content-Type"));
        
        // ⏳ Définir le cache de la réponse OPTIONS pour 3600 secondes (1 heure)
        config.setMaxAge(3600L);
        
        // 🔗 Appliquer la configuration CORS à toutes les routes
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
