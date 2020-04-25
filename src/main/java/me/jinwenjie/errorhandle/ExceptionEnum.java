package me.jinwenjie.errorhandle;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    USER_ACCOUNT_WRONG(10001, "account or password wrong", HttpStatus.UNAUTHORIZED),
    USER_ACCOUNT_EMPTY(10002, "email and phone number both are empty", HttpStatus.NOT_ACCEPTABLE);

    private Integer code;
    private String error;
    private HttpStatus httpStatus;

    ExceptionEnum(int code, String error, HttpStatus status) {
        this.code = code;
        this.error = error;
        this.httpStatus = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
