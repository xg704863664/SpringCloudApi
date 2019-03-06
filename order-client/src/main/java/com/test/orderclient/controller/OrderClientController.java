package com.test.orderclient.controller;

import com.test.orderclient.client.RpcClient;
import com.test.orderclient.entity.Order;
import com.test.orderclient.redis.RedisLock;
import com.test.orderclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderClientController {
    @Autowired
    private RedisLock redisLock;

    @Autowired
    private OrderService orderService;

    public static Map<Integer,Integer> m = new HashMap<>();


    private static int i = 1;

    @GetMapping("/test")
    public Order getInfo(){
        return orderService.findOne();
    }

    @GetMapping("/insert")
    public Long insert(){
        return orderService.insert();
    }

    @GetMapping("/all")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/in")
    public List<Order> findIn(){
        return orderService.findIn();
    }
}
