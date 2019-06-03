package com.eurekaclient.eurekaclient.controller;


import com.eurekaclient.eurekaclient.service.RedisServerTest;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class OrderController {
    @Value("${config.info}")
    private String configInfo;
    @Autowired
    private RedisServerTest redisServerTest;


    @GetMapping("/call")
    public String callBackCode(@RequestParam(value = "code")String code, @RequestParam("state")String state){
        System.out.println("code:"+code+" state:"+state);
        return "success";
    }
    @GetMapping("/getInfo")
    public List<String> getInfo(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("serverPort:"+configInfo);
        System.out.println("访问了！");
        return list;
    }

    @GetMapping("/test1")
    public List<String> getInfo1(){
        List<String> list = new ArrayList<>();
        list.add("6");
        list.add("7");
//        redisServerTest.c();/**/
//        OrderController orderController = (OrderController) AopContext.currentProxy();
//        orderController.ad();
        return list;
    }

    @Async
    public void ad(){

        System.out.println(Thread.currentThread().getName()+"");
    }

    @GetMapping("/add")
    public String add(){

        return "success";
    }

}
