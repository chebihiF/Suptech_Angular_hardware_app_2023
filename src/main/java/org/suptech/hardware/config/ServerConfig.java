package org.suptech.hardware.config;


import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.suptech.hardware.enumeration.Status;
import org.suptech.hardware.model.Server;
import org.suptech.hardware.repo.ServerRepository;

import java.util.Arrays;


@Configuration
@RequiredArgsConstructor
public class ServerConfig {

    private final ServerRepository serverRepository;

    @Bean
    CommandLineRunner init_servers(){
        return args -> {
          serverRepository.save(new Server(null,"192.168.1.156","Ubuntu linux","16 GB","Personal PC", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.15","Fedora linux","12 GB","Personal PC", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.160","Macos","64 GB","Gaming PC", "", Status.SERVER_DOWN));
          serverRepository.save(new Server(null,"192.168.1.12","Ms 2008","6 GB","App Server", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.16","CentOs","8 GB","Web Server", "", Status.SERVER_DOWN));
          serverRepository.save(new Server(null,"192.168.1.22","Red Hat Entreprise Linux","mail server","Personal PC", "", Status.SERVER_DOWN));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Accept","Jwt-Token","Authorization","Origin, Accept","X-Requested-With","Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Access-Control-Allow-Credentials","Filename",
                "Accept","Jwt-Token","Authorization","Origin, Accept","X-Requested-With","Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


}
