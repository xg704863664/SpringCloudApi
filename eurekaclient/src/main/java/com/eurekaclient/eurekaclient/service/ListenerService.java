//package com.eurekaclient.eurekaclient.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.support.MessageBuilder;
//
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@EnableBinding(value = {MqSinkI.class})
//public class ListenerService {
//    @Autowired
//    private MqSinkI mqSinkI;
//
//
//    @StreamListener(MqSinkI.INPUT)
//    public void messageListener(String s){
//        System.out.println("收到信息:" +s);
//    }
//
////    @PostConstruct
//    public void send(){
//        System.out.println("发送-------------");
////        List<Integer> l = new ArrayList<>();
////        l.add(123);
//        String a = "!23";
//        mqSinkI.output().send(MessageBuilder.withPayload(new Msg(a)).build());
////        kafkaTemplate.send("test-3",a);
//    }
//}
