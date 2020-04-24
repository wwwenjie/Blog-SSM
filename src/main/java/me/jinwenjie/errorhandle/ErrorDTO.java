package me.jinwenjie.errorhandle;

import com.fasterxml.jackson.annotation.JsonInclude;

// http status will always be 200, if you need to set http status, use me.jinwenjie.errorhandle.CustomException
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private final Integer code;
    private final String error;
    private Object detail;

    // error and return code, error msg
    public ErrorDTO(Integer code, String error) {
        this.code = code;
        this.error = error;
    }

    // error and return code, error msg, detail error(data)
    public ErrorDTO(Integer code, String error, Object detail) {
        this.code = code;
        this.error = error;
        this.detail = detail;
    }

    public Integer getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public Object getDetail() {
        return detail;
    }
}
