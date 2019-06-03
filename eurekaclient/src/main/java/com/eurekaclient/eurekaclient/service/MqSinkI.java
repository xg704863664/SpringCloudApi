//package com.eurekaclient.eurekaclient.service;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;
//
//public interface MqSinkI {
//    String INPUT = "input";
//    String OUTPUT = "output";
//
//    @Output(MqSinkI.OUTPUT)
//    MessageChannel output();
//    @Input(MqSinkI.INPUT)
//    SubscribableChannel input();
//}
