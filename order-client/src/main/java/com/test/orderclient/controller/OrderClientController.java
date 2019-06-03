package com.test.orderclient.controller;

import com.test.orderclient.entity.Order;
import com.test.orderclient.entity.Test;
import com.test.orderclient.redis.RedisLock;
import com.test.orderclient.service.MsgService;
import com.test.orderclient.service.OrderService;
import com.test.orderclient.service.TestRedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderClientController {
    @Autowired
    private RedisLock redisLock;
    @Autowired
    private TestRedisServer testRedisServer;

    @Autowired
    private OrderService orderService;
    @Autowired
    private MsgService msgService;
    public static Map<Integer,Integer> m = new HashMap<>();


    private static int i = 1;

    @GetMapping("/test")
    public Test getInfo(){
//        redisLock.getLock("123","123",20L,60*1000L);

        return  orderService.findIn();
    }
    @GetMapping("/test/del")
    public Order getInfoDel(){
//        redisLock.getLock("123","123",20L,60*1000L);
        testRedisServer.del();
        return new Order();
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
    public String findIn(){
        return "123";
    }

    @GetMapping("/call")
    public String callBackCode(@RequestParam(value = "code")String code,@RequestParam("state")String state){
            System.out.println("code:"+code+" state:"+state);
            return "success";
    }

}
