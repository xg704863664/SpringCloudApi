//package com.test.orderclient.config;
//
//import com.google.common.collect.ImmutableMap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.*;
//import org.springframework.data.redis.connection.jedis.JedisConnection;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//
//@Configuration
//public class RedisConfig {
//
////    @Bean
////    public CacheManager buildCacheManager(RedisConnectionFactory redisConnectionFactory) {
////        RedisCacheManager redisCacheManager = RedisCacheManager.create(redisConnectionFactory);
////        return redisCacheManager;
////    }
////    public interface CacheNames {
////        /** 15分钟缓存组 */
////        String CACHE_15MINS = "cp_salary:cache:15m";
////        /** 30分钟缓存组 */
////        String CACHE_30MINS = "cp_salary:cache:30m";
////        /** 60分钟缓存组 */
////        String CACHE_60MINS = "cp_salary:cache:60m";
////        /** 180分钟缓存组 */
////        String CACHE_180MINS = "cp_salary:cache:180m";
////    }
////    @Bean
////    public RedisCacheCustomizer redisCacheManagerCustomizer() {
////        return new RedisCacheCustomizer();
////    }
////    private static class RedisCacheCustomizer
////            implements CacheManagerCustomizer<RedisCacheManager> {
////        /** CacheManager缓存自定义初始化比较早，尽量不要@autowired 其他spring 组件 */
////        @Override
////        public void customize(RedisCacheManager cacheManager) {
////            Map<String, Long> expires = ImmutableMap.<String, Long>builder()
////                    .put(CacheNames.CACHE_15MINS, TimeUnit.MINUTES.toSeconds(15))
////                    .put(CacheNames.CACHE_30MINS, TimeUnit.MINUTES.toSeconds(30))
////                    .put(CacheNames.CACHE_60MINS, TimeUnit.MINUTES.toSeconds(60))
////                    .put(CacheNames.CACHE_180MINS, TimeUnit.MINUTES.toSeconds(180)).build();
////            // spring cache是根据cache name查找缓存过期时长的，如果找不到，则使用默认值
////        }
////    }
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private long maxWait;
//    @Value("${spring.redis.cluster.nodes}")
//    private List<String> nodes = new ArrayList<>();
//    @Value("${spring.redis.cluster.max-redirects}")
//    private int maxRedirects;
//    @Value("${spring.redis.password}")
//    private String password;
//
//
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWait);
//        jedisPoolConfig.setTestOnCreate(false);
//        jedisPoolConfig.setTestOnBorrow(true);
//        jedisPoolConfig.setTestOnReturn(false);
//        jedisPoolConfig.setTestWhileIdle(true);
//        return jedisPoolConfig;
//    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
//        for (String node :nodes) {
//            String[] nodeInfo = node.split(":");
//            redisClusterConfiguration.addClusterNode(new RedisNode(nodeInfo[0],Integer.parseInt(nodeInfo[1])));
//        }
//        redisClusterConfiguration.setMaxRedirects(maxRedirects);
//        redisClusterConfiguration.setPassword(password);
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
//        return factory;
//    }
//
//
//}
