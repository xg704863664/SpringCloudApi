package com.erkua.erkua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErkuaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErkuaApplication.class, args);
    }

}

