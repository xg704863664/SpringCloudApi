package com.test.orderclient.client;

import com.test.orderclient.controller.OrderClientController;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class initMap {
    @PostConstruct
    public void init(){
        System.out.println("初始化--");
        OrderClientController.m.put(1,1);
        OrderClientController.m.put(2,2);
        OrderClientController.m.put(3,3);
        OrderClientController.m.put(4,4);
        OrderClientController.m.put(5,5);
    }
}
