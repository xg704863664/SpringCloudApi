//package com.eurekaclient.eurekaclient.config;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.serialization.ByteArrayDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//
//import org.apache.spark.streaming.Durations;
//import org.apache.spark.streaming.api.java.JavaInputDStream;
//import org.apache.spark.streaming.api.java.JavaStreamingContext;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//public class SparkStreamingKafkaConfig implements Serializable {
//    private transient JavaSparkContext javaSparkContext;
//    private transient  JavaStreamingContext javaStreamingContext;
//    private transient  SparkConf sparkConf;
//    private static final Map<String, Object> kafkaParams = new HashMap<>();
//    private Collection<String> topics = Arrays.asList("test-6");//配置topic，可以是数组
//    static {
//        kafkaParams.put("bootstrap.servers", "192.168.116.128:9092,192.168.116.129:9092");//多个可用ip可用","隔开
//        kafkaParams.put("key.deserializer", StringDeserializer.class);
//        kafkaParams.put("value.deserializer", StringDeserializer.class);
//        kafkaParams.put("group.id", "sparkStreaming");
//        kafkaParams.put("auto.offset.reset","earliest");
//    }
//    @Bean
//    public SparkConf creatSparkConf(){
//        sparkConf = new SparkConf();
//        sparkConf.setMaster("spark://192.168.116.129:7077");
//        sparkConf.setAppName("EurekaclientApplication");
//        sparkConf.set("spark.streaming.stopGracefullyOnShutdown","true");
//        sparkConf.set("spark.default.parallelism", "6");
//        sparkConf.set("spark.streaming.kafka.maxRatePerPartition", "1");
//        return sparkConf;
//    }
//
//    @Bean
//    public JavaSparkContext buildJavaSparkContext(SparkConf sparkConf){
//        javaSparkContext = new JavaSparkContext(sparkConf);
//        return javaSparkContext;
//    }
//
//    @Bean
//    public JavaStreamingContext createJavaStreamingContext(JavaSparkContext javaSparkContext){
//        javaStreamingContext = new JavaStreamingContext(javaSparkContext, Durations.seconds(1));
//        return javaStreamingContext;
//    }
//
////    @Bean
////    public JavaInputDStream<ConsumerRecord<String, String>>  buildJavaInputDStream(JavaStreamingContext javaStreamingContext){
////        return KafkaUtils.createDirectStream(javaStreamingContext, LocationStrategies.PreferConsistent(), ConsumerStrategies.Subscribe(topics,kafkaParams));
////    }
//}
