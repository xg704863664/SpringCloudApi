package com.test.zuulserver;

import com.test.zuulserver.config.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
@EnableHystrix
public class ZuulServerApplication {
//    @Bean
//    public MyFilter initMyFilter(){
//        return new MyFilter();
//    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}

