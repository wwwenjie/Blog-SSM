package me.jinwenjie.model;

public class ArticleCategoryKey {
    private Long articleId;

    private Long categoryId;

    public ArticleCategoryKey(Long articleId, Long categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }

    public ArticleCategoryKey() {
        super();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}