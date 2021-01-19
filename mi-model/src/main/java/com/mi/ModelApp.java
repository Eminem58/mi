package com.mi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mi.**.dao")
public class ModelApp {

    public static void main(String[] args) {
        SpringApplication.run(ModelApp.class, args);
    }

}
