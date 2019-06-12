package com.swpu.funchat.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

/**
 * Description: https://www.cnblogs.com/LOVE0612/p/9913336.html
 * Created by Zhu Peng on 2019/6/12
 */
@Component
public class OauthConfig {

    @Bean
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
        return new RedisTokenStore(redisConnectionFactory);
    }
}
