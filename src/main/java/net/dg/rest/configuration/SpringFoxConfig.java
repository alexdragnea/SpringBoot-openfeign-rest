package net.dg.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage( "net.dg.rest" ))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot REST Application with OpenFeign")
                .description("SpringBoot REST integration with TheCatApi.com")
                .version("1.0")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .contact(new Contact("Dragnea Alexandru", "", ""))
                .build();
    }

}