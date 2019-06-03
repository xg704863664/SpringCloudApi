package com.eurekaclient.eurekaclient.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RedisServerTest {
    @Async
   public void a(){
       System.out.println(Thread.currentThread().getName()+"线程");
   }

    @Async
    public void b(){
        System.out.println(Thread.currentThread().getName()+"线程");
    }

    public void c(){
        RedisServerTest redisServerTest = (RedisServerTest) AopContext.currentProxy();
        redisServerTest.a();
    }

}
