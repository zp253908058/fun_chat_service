package com.swpu.funchat.model.dto;

import org.apache.ibatis.type.Alias;

/**
 * Description: 用户认证信息
 * Created by Zhu Peng on 2019/6/12
 */
@Alias("UserAuth")
public class UserAuth {
    private long id;                          //id
    private long userId;                      //用户id
    private int identityType;                 //登录类型 (手机号/邮箱/用户名) 或第三方应用名称 (微信 , 微博等)
    private String identifier;                //标识 (手机号/邮箱/用户名或第三方应用的唯一标识)
    private String credential;                //密码凭证 (站内的保存密码 , 站外的不保存或保存 token)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", userId=" + userId +
                ", identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential='" + credential + '\'' +
                '}';
    }
}
