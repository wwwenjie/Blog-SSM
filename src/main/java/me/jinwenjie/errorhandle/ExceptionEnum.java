package me.jinwenjie.errorhandle;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    USER_LOGIN_ERROR(10001, "account or password wrong", HttpStatus.BAD_REQUEST);

    private int code;
    private String error;
    private HttpStatus httpStatus;

    ExceptionEnum(int code, String error, HttpStatus status) {
        this.code = code;
        this.error = error;
        this.httpStatus = status;
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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
