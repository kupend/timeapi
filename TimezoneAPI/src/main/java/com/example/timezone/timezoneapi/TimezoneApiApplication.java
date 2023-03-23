package com.example.timezone.timezoneapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TimezoneApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimezoneApiApplication.class, args);
    }

    @Bean
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }

}
