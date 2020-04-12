package me.jinwenjie.model;

public class Label {
    private Long labelId;

    private String labelName;

    private String labelAlias;

    private String labelDescription;

    public Label(Long labelId, String labelName, String labelAlias, String labelDescription) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.labelAlias = labelAlias;
        this.labelDescription = labelDescription;
    }

    public Label() {
        super();
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias == null ? null : labelAlias.trim();
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription == null ? null : labelDescription.trim();
    }
}