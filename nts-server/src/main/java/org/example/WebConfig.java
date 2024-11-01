package org.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Prilagodite ovo ako je potrebno
                .allowedOrigins("http://localhost:3000") // Dozvolite pristup samo iz ove adrese
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozvolite metode koje želite
                .allowedHeaders("*") // Dozvolite sve header-e
                .allowCredentials(true); // Opcionalno, dozvolite slanje kolačića
    }
}

