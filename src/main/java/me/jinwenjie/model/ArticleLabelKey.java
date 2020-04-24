package me.jinwenjie.model;

public class ArticleLabelKey {
    private Integer articleId;

    private Integer labelId;

    public ArticleLabelKey(Integer articleId, Integer labelId) {
        this.articleId = articleId;
        this.labelId = labelId;
    }

    public ArticleLabelKey() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}