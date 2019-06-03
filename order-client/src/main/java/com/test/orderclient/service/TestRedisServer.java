package com.test.orderclient.service;


import com.test.orderclient.entity.Order;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
@Log4j
public class TestRedisServer {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void testRedis(Integer c){
        CountDownLatch countDownLatch = new CountDownLatch(c);
        for (int i = 0; i < c; i++) {
            Integer a = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    redisTemplate.opsForValue().set("test-"+a,a+"");
                    log.info("redis写入成功"+Thread.currentThread().getName());
                }
            }).start();
            countDownLatch.countDown();
        }
    }

    public void del (){
        redisTemplate.delete(redisTemplate.keys("test-*"));
    }

    public void redisTest(){
//        redisTemplate.setEnableTransactionSupport(false);
//        redisTemplate.multi();
        redisTemplate.opsForValue().set("ee","123");
//        redisTemplate.exec();
    }

    @Cacheable(cacheNames ="2:2:2" )
    public Order test(String id){
        log.info("不走缓存---");
        Order o = new Order();
        o.setOrderNum("123");
        return o;
    }
}
