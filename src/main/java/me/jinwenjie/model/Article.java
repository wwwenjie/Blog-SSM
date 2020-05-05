package me.jinwenjie.model;

import java.util.Date;

public class Article {
    private Integer articleId;

    private Integer userId;

    private String articleTitle;

    private String articleImage;

    private Integer articleViews;

    private Integer articleCommentCount;

    private Date articleDate;

    private Date articleLastModifyDate;

    private String articleContent;

    public Article(Integer articleId, Integer userId, String articleTitle, String articleImage, Integer articleViews, Integer articleCommentCount, Date articleDate, Date articleLastModifyDate) {
        this.articleId = articleId;
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleImage = articleImage;
        this.articleViews = articleViews;
        this.articleCommentCount = articleCommentCount;
        this.articleDate = articleDate;
        this.articleLastModifyDate = articleLastModifyDate;
    }

    public Article(Integer articleId, Integer userId, String articleTitle, String articleImage, Integer articleViews, Integer articleCommentCount, Date articleDate, Date articleLastModifyDate, String articleContent) {
        this.articleId = articleId;
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleImage = articleImage;
        this.articleViews = articleViews;
        this.articleCommentCount = articleCommentCount;
        this.articleDate = articleDate;
        this.articleLastModifyDate = articleLastModifyDate;
        this.articleContent = articleContent;
    }

    public Article() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage == null ? null : articleImage.trim();
    }

    public Integer getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Integer articleViews) {
        this.articleViews = articleViews;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public Date getArticleLastModifyDate() {
        return articleLastModifyDate;
    }

    public void setArticleLastModifyDate(Date articleLastModifyDate) {
        this.articleLastModifyDate = articleLastModifyDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}