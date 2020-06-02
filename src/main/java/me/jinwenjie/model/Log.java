package me.jinwenjie.model;

import java.util.Date;

public class Log {
    private Integer id;

    private String action;

    private String user;

    private String ip;

    private Date date;

    public Log(Integer id, String action, String user, String ip, Date date) {
        this.id = id;
        this.action = action;
        this.user = user;
        this.ip = ip;
        this.date = date;
    }

    public Log() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}