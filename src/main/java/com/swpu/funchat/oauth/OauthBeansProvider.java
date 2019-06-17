package com.swpu.funchat.oauth;

import com.swpu.funchat.web.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Description: https://www.cnblogs.com/LOVE0612/p/9913336.html
 * Created by Zhu Peng on 2019/6/12
 */
@Component
public class OauthBeansProvider {

    private final DataSource mDataSource;

    @Autowired
    public OauthBeansProvider(DataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    @Bean
    @Qualifier("jdbcClientDetailsService")
    public ClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(mDataSource);
    }

    @Bean
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
