package com.test.orderclient.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisTest {
     @Autowired
     private RedisLock redisLock;


}
