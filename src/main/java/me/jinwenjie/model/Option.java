package me.jinwenjie.model;

public class Option {
    private Long optionId;

    private String optionName;

    private String optionEnable;

    private String optionValue;

    public Option(Long optionId, String optionName, String optionEnable) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionEnable = optionEnable;
    }

    public Option(Long optionId, String optionName, String optionEnable, String optionValue) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionEnable = optionEnable;
        this.optionValue = optionValue;
    }

    public Option() {
        super();
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public String getOptionEnable() {
        return optionEnable;
    }

    public void setOptionEnable(String optionEnable) {
        this.optionEnable = optionEnable == null ? null : optionEnable.trim();
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue == null ? null : optionValue.trim();
    }
}