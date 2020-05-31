package me.jinwenjie.errorhandle;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    USER_ACCOUNT_WRONG(10001, "email or password is wrong", HttpStatus.UNAUTHORIZED),
    USER_ACCOUNT_EMPTY(10002, "email or password is empty", HttpStatus.NOT_ACCEPTABLE),
    AUTH_REQUIRED(40001, "the content you request need auth", HttpStatus.UNAUTHORIZED),
    AUTH_NOT_ADMIN(40002, "only admin can access it", HttpStatus.UNAUTHORIZED);

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
