package com.swpu.funchat.model.dto;

/**
 * Description: 用户Id
 * Created by Zhu Peng on 2019/6/12
 */
public class UserId {
    private long id;
    private long userId;
    private long createDate;
    private int idState;

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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }
}
