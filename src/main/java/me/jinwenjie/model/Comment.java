package me.jinwenjie.model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer userId;

    private String userName;

    private String userIp;

    private Integer articleId;

    private Date commentDate;

    private Integer parentCommentId;

    private String commentContent;

    public Comment(Integer commentId, Integer userId, String userName, String userIp, Integer articleId, Date commentDate, Integer parentCommentId) {
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.userIp = userIp;
        this.articleId = articleId;
        this.commentDate = commentDate;
        this.parentCommentId = parentCommentId;
    }

    public Comment(Integer commentId, Integer userId, String userName, String userIp, Integer articleId, Date commentDate, Integer parentCommentId, String commentContent) {
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.userIp = userIp;
        this.articleId = articleId;
        this.commentDate = commentDate;
        this.parentCommentId = parentCommentId;
        this.commentContent = commentContent;
    }

    public Comment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}