package me.jinwenjie.model;

import java.util.Date;

public class Article {
    private Long articleId;

    private Long userId;

    private String articleTitle;

    private Long articleViews;

    private Long articleCommentCount;

    private Date articleDate;

    private Date articleLastModifyDate;

    private String articleContent;

    public Article(Long articleId, Long userId, String articleTitle, Long articleViews, Long articleCommentCount, Date articleDate, Date articleLastModifyDate) {
        this.articleId = articleId;
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleViews = articleViews;
        this.articleCommentCount = articleCommentCount;
        this.articleDate = articleDate;
        this.articleLastModifyDate = articleLastModifyDate;
    }

    public Article(Long articleId, Long userId, String articleTitle, Long articleViews, Long articleCommentCount, Date articleDate, Date articleLastModifyDate, String articleContent) {
        this.articleId = articleId;
        this.userId = userId;
        this.articleTitle = articleTitle;
        this.articleViews = articleViews;
        this.articleCommentCount = articleCommentCount;
        this.articleDate = articleDate;
        this.articleLastModifyDate = articleLastModifyDate;
        this.articleContent = articleContent;
    }

    public Article() {
        super();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
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