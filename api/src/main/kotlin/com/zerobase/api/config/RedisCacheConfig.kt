package com.zerobase.api.config

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@Configuration
@EnableCaching
class RedisCacheConfig {

    @Bean
    fun redisCacheManager(cacheFatory: RedisConnectionFactory): RedisCacheManager {
        val redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                    GenericJackson2JsonRedisSerializer()
                )) // String 값이 아니어도 처리할 수 있도록
            .entryTtl(Duration.ofMinutes(10))
        
        return RedisCacheManager
            .RedisCacheManagerBuilder
            .fromConnectionFactory(cacheFatory)
            .cacheDefaults(redisCacheConfig)
            .build()
    }
}