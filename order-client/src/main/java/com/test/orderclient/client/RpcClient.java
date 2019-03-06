package com.test.orderclient.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.orderclient.FallBack.RpcClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "order-server",fallback = RpcClientFallBack.class)
public interface RpcClient {

    @GetMapping(value = "/getInfo")
     List<String> getInfo();
}
