package net.dg.springbootopefeignrestapi.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "client.cat-api")
public class CatApiProperties {

    private String apiKey;

}