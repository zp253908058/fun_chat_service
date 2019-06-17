package com.swpu.funchat.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.vote.ScopeVoter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


    private ClientDetailsService mClientDetailsService;

    private AuthenticationManager mAuthenticationManager;

    private TokenStore mTokenStore;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        mAuthenticationManager = authenticationManager;
    }

    @Autowired
    @Qualifier("jdbcClientDetailsService")
    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        mClientDetailsService = clientDetailsService;
    }

    @Autowired
    public void setTokenStore(TokenStore tokenStore) {
        mTokenStore = tokenStore;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(mClientDetailsService);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(mAuthenticationManager).tokenStore(mTokenStore);
    }

    @Bean
    public UnanimousBased oauth2AccessDecisionManager() {
        List<AccessDecisionVoter<?>> list = new ArrayList<>();
        list.add(new ScopeVoter());
        list.add(new RoleVoter());
        list.add(new AuthenticatedVoter());
        return new UnanimousBased(list);
    }
}
