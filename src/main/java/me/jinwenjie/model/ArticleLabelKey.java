package me.jinwenjie.model;

public class ArticleLabelKey {
    private Long articleId;

    private Long labelId;

    public ArticleLabelKey(Long articleId, Long labelId) {
        this.articleId = articleId;
        this.labelId = labelId;
    }

    public ArticleLabelKey() {
        super();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }
}