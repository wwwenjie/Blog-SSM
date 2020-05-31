package me.jinwenjie.model;

public class Role {
    private Integer userId;

    private Integer authId;

    public Role(Integer userId, Integer authId) {
        this.userId = userId;
        this.authId = authId;
    }

    public Role() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
}