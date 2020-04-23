package me.jinwenjie.errorhandle;

public class ErrorDTO {
    private int code;
    private String error;
    private String detail;

    public ErrorDTO(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public ErrorDTO(int code, String error, String detail) {
        this.code = code;
        this.error = error;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
