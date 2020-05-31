package me.jinwenjie.model;

public class Authority {
    private Integer authId;

    private String name;

    private String url;

    public Authority(Integer authId, String name, String url) {
        this.authId = authId;
        this.name = name;
        this.url = url;
    }

    public Authority() {
        super();
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}