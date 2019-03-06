package com.test.orderclient.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class RedisLock {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    private Logger logger = LoggerFactory.getLogger(RedisLock.class);
    /**
     *
     * @param key 锁的名称
     * @param value 锁的值
     * @param useTime 获取锁的时间
     * @param expireSeconds 锁的失效时间
     * @return
     */
    public  boolean getLock(String key,String value,long useTime,long expireSeconds){
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        boolean locked=false;
        long endTime = useTime + System.currentTimeMillis();
        try {
                while (System.currentTimeMillis()<=endTime) {
                    boolean success = redisConnection.setNX(key.getBytes("utf-8"), value.getBytes("utf-8"));
                    if (success) {
                        if(redisConnection.ttl(key.getBytes("utf-8"))==-1){
                            locked = true;
                            if(redisConnection.expire(key.getBytes("utf-8"), expireSeconds)){
                                logger.info("redis设置锁过期时间成功--"+key);
                            }else {
                                logger.info("redis设置锁过期时间失败--"+key);
                            }
                            return locked;
                        }
                    }
                    /**
                     * 防止上一次操作的线程锁加过期时间失败
                     */
                    if(redisConnection.ttl(key.getBytes("utf-8"))==-1){
                        if(redisConnection.expire(key.getBytes("utf-8"), expireSeconds)){
                            logger.info("redis设置锁过期时间成功--"+key);
                        }
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (redisConnection!=null){
                RedisConnectionUtils.releaseConnection(redisConnection,redisConnectionFactory);
            }
        }
       return locked;
    }

    public  boolean releaseLock(String key){
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        try {
          if (redisConnection.del(key.getBytes("utf-8"))==1){
                 logger.info("redis删除锁成功--"+key);
          }else {
              logger.info("redis删除锁失败，没有 "+key+" 被删除--");
          }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            if (redisConnection!=null){
                RedisConnectionUtils.releaseConnection(redisConnection,redisConnectionFactory);
            }
        }
        return false;
    }


}
