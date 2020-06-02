package me.jinwenjie.model;

public class Option {
    private Integer optionId;

    private String optionName;

    private String optionValue;

    private String optionEnable;

    public Option(Integer optionId, String optionName, String optionValue, String optionEnable) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.optionEnable = optionEnable;
    }

    public Option() {
        super();
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue == null ? null : optionValue.trim();
    }

    public String getOptionEnable() {
        return optionEnable;
    }

    public void setOptionEnable(String optionEnable) {
        this.optionEnable = optionEnable == null ? null : optionEnable.trim();
    }
}