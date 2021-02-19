package com.mi.account2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 金彪
 * @date 2021-02-01
 */
@SpringBootApplication
public class Account2App {
    public static void main(String[] args) {
        SpringApplication.run(Account2App.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
