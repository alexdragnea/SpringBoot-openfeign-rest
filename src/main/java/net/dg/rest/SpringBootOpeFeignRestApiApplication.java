package net.dg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootOpeFeignRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOpeFeignRestApiApplication.class, args);
    }

}
