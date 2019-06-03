//package com.eurekaclient.eurekaclient.service;
//
//import org.springframework.kafka.support.converter.KafkaMessageHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageHeaders;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.locks.Lock;
//
//public class Msg implements Message<String> {
//    private String json;
//    public Msg(String json){
//        this.json = json;
//    }
//    @Override
//    public String getPayload() {
//        return json;
//    }
//
//    @Override
//    public MessageHeaders getHeaders() {
//        Map<String,Object> map = new HashMap<>();
//        map.put("context-type","application/json");
//        map.put("id",UUID.randomUUID().toString());
//        return new MessageHeaders(map);
//    }
//}
