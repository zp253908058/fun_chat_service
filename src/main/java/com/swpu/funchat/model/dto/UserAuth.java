package com.swpu.funchat.model.dto;

/**
 * Description: 用户认证信息
 * Created by Zhu Peng on 2019/6/12
 */
public class UserAuth {
    private long id;                          //id
    private long userId;                      //用户id
    private String identityType;              //登录类型 (手机号/邮箱/用户名) 或第三方应用名称 (微信 , 微博等)
    private String identifier;                //标识 (手机号/邮箱/用户名或第三方应用的唯一标识)
    private String credential;                //密码凭证 (站内的保存密码 , 站外的不保存或保存 token)
    private long createDate;                  //数据创建时间
    private long lastAuthDate;                //随后一次认证时间

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

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getLastAuthDate() {
        return lastAuthDate;
    }

    public void setLastAuthDate(long lastAuthDate) {
        this.lastAuthDate = lastAuthDate;
    }
}
