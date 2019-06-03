//package com.test.orderclient.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RocketMQMessageListener(topic = "test-topic-4", consumerGroup = "my-consumer_test-topic-4")
//public class MyConsumer implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String s) {
//        log.info("收到消息："+s);
//    }
//}
