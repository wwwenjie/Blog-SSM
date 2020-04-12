package me.jinwenjie.model;

import java.util.Date;

public class Comment {
    private Long commentId;

    private Long userId;

    private String userName;

    private String userIp;

    private Long articleId;

    private Date commentDate;

    private Long parentCommentId;

    private String commentContent;

    public Comment(Long commentId, Long userId, String userName, String userIp, Long articleId, Date commentDate, Long parentCommentId) {
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.userIp = userIp;
        this.articleId = articleId;
        this.commentDate = commentDate;
        this.parentCommentId = parentCommentId;
    }

    public Comment(Long commentId, Long userId, String userName, String userIp, Long articleId, Date commentDate, Long parentCommentId, String commentContent) {
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}