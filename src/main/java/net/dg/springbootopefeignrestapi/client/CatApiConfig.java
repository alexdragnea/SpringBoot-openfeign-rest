package net.dg.springbootopefeignrestapi.client;

import feign.Logger;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
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