//package com.eurekaclient.eurekaclient.service;
//
//
//
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.serialization.ByteArrayDeserializer;
//import org.apache.spark.streaming.api.java.*;
//
//import org.apache.spark.streaming.kafka010.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import scala.Tuple2;
//
//import javax.annotation.PostConstruct;
//import java.io.Serializable;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Service
//public class SparkService implements Serializable {
//    private static final Map<String, Object> kafkaParams = new HashMap<>();
//    private static Set<String> topics = new HashSet<String>();//配置topic，可以是数组
//    static {
//        topics.add("test-6");
//        kafkaParams.put("bootstrap.servers", "192.168.116.128:9092,192.168.116.129:9092");//多个可用ip可用","隔开
//        kafkaParams.put("key.deserializer", ByteArrayDeserializer.class);
//        kafkaParams.put("value.deserializer", ByteArrayDeserializer.class);
//        kafkaParams.put("group.id", "sparkStreaming");
////        kafkaParams.put("auto.offset.reset","earliest");
//    }
//    @Autowired
//    private transient JavaStreamingContext javaStreamingContext;
//    private static AtomicLong orderCount = new AtomicLong(0);
//
//    public void test(){
//        try {
////            JavaPairInputDStream<String, String> javaReceiverInputDStream = KafkaUtils.createDirectStream(javaStreamingContext,String.class,String.class, StringDecoder.class,StringDecoder.class,kafkaParams,topics);
//            JavaInputDStream<ConsumerRecord<String, String>> javaReceiverInputDStream = KafkaUtils.createDirectStream(javaStreamingContext, LocationStrategies.PreferConsistent(), ConsumerStrategies.Subscribe(topics,kafkaParams));
////            JavaPairDStream<String, String> counts = javaReceiverInputDStream.flatMap(x -> Arrays.asList(x.value().split(" ")).iterator()).mapToPair(x -> new Tuple2<>(x, 1))
////                    .reduceByKey((x, y) -> x + y);
////            counts.print();
//            javaReceiverInputDStream.count().print();
////            javaReceiverInputDStream.
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
////        JavaDStream<String> javaDStream = javaInputDStream.map(new Function<ConsumerRecord<String, String>, String>() {
////            @Override
////            public String call(ConsumerRecord<String, String> consumerRecord) throws Exception {
////                System.out.println("----1---------"+consumerRecord.value());
////                return consumerRecord.value();
////            }
////        }).cache();
////
////        javaDStream.foreachRDD(new VoidFunction<JavaRDD<String>>() {
////            @Override
////            public void call(JavaRDD<String> stringJavaRDD) throws Exception {
////               Long a =  stringJavaRDD.count();
////               if (a>0){
////                   orderCount.addAndGet(a);
////               }
////            }
////        });
////        javaDStream.print();
//        javaStreamingContext.start();
//        try {
//            javaStreamingContext.awaitTermination();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @PostConstruct
//    public void ss(){
//        new Thread() {
//            @Override
//            public void run() {
//                test();
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("---------"+orderCount.get());
//                }
//            }
//        }.start();
//
//    }
//}
