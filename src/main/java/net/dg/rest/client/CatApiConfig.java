package net.dg.rest.client;

import feign.Logger;
import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class CatApiConfig {

    private final CatApiProperties catApiProperties;

    @Bean
    public Logger.Level catApiLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor catApiRequestInterceptor() {
        return new CatApiAuthInterceptor(catApiProperties);
    }

}