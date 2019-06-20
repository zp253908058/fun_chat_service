package com.swpu.funchat.oauth;

/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/12
 */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
public class AuthorizationServerConfiguration  {

//
//    private ClientDetailsService mClientDetailsService;
//
//    private AuthenticationManager mAuthenticationManager;
//
//    private TokenStore mTokenStore;
//
//    @Autowired
//    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//        mAuthenticationManager = authenticationManager;
//    }
//
//    @Autowired
//    @Qualifier("jdbcClientDetailsService")
//    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
//        mClientDetailsService = clientDetailsService;
//    }
//
//    @Autowired
//    public void setTokenStore(TokenStore tokenStore) {
//        mTokenStore = tokenStore;
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(mClientDetailsService);
//    }
//
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        //允许表单认证
//        oauthServer.allowFormAuthenticationForClients();
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(mAuthenticationManager).tokenStore(mTokenStore);
//    }
//
//    @Bean
//    public UnanimousBased oauth2AccessDecisionManager() {
//        List<AccessDecisionVoter<?>> list = new ArrayList<>();
//        list.add(new ScopeVoter());
//        list.add(new RoleVoter());
//        list.add(new AuthenticatedVoter());
//        return new UnanimousBased(list);
//    }
}
