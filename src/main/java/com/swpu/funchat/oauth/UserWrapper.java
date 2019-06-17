package com.swpu.funchat.oauth;

import com.swpu.funchat.model.dto.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see UserWrapper
 * @since 2019-06-15
 */
public class UserWrapper implements UserDetails {

    private UserAuth mUserAuth;

    public UserWrapper(UserAuth entity) {
        super();
        this.mUserAuth = entity;
    }

    public UserAuth getUserAuth() {
        return mUserAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.mUserAuth = userAuth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthorityImpl authority = new GrantedAuthorityImpl();
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return mUserAuth.getCredential();
    }

    @Override
    public String getUsername() {
        return mUserAuth.getIdentifier();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return mUserAuth.toString();
    }
}
