package me.jinwenjie.errorhandle;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private int code;
    private String error;
    private HttpStatus httpStatus;

    public CustomException(ExceptionEnum e) {
        this.code = e.getCode();
        this.error = e.getError();
        this.httpStatus = e.getHttpStatus();
    }

    public CustomException(int code, String error) {
        this.code = code;
        this.error = error;
        this.httpStatus = HttpStatus.OK;
    }

    public CustomException(int code, String error, HttpStatus httpStatus) {
        this.code = code;
        this.error = error;
        this.httpStatus = httpStatus;
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
