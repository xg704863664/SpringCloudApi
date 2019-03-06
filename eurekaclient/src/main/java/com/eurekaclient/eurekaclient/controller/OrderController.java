package com.eurekaclient.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

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
        list.add("serverPort:"+serverPort);
        System.out.println("访问了！");
        return list;
    }

    @GetMapping("/test1")
    public List<String> getInfo1(){
        List<String> list = new ArrayList<>();
        list.add("1");
        return list;
    }

}
