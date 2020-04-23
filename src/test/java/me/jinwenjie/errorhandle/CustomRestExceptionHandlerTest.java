package me.jinwenjie.errorhandle;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomRestExceptionHandlerTest {
    final int CODE = 1000;
    final String ERROR = "TEST ERROR";
    final HttpStatus STATUS = HttpStatus.OK;

    @Test
    public void handleCustomerException() {
        // from enum
        CustomException customError = new CustomException(ExceptionEnum.USER_LOGIN_ERROR);
        CustomRestExceptionHandler test = new CustomRestExceptionHandler();
        ResponseEntity<Object> result = test.handleCustomerException(customError);
        ErrorDTO errorDTO = (ErrorDTO) result.getBody();
        assert errorDTO != null;
        assertEquals(errorDTO.getCode(), ExceptionEnum.USER_LOGIN_ERROR.getCode());
        assertEquals(errorDTO.getError(), ExceptionEnum.USER_LOGIN_ERROR.getError());
        assertEquals(result.getStatusCode(), ExceptionEnum.USER_LOGIN_ERROR.getHttpStatus());
        assertNull(errorDTO.getDetail());
        // from custom
        customError.setCode(CODE);
        customError.setError(ERROR);
        customError.setHttpStatus(STATUS);
        result = test.handleCustomerException(customError);
        errorDTO = (ErrorDTO) result.getBody();
        assert errorDTO != null;
        assertEquals(errorDTO.getCode(), CODE);
        assertEquals(errorDTO.getError(), ERROR);
        assertEquals(result.getStatusCode(), STATUS);
        assertNull(errorDTO.getDetail());
    }

    @Test
    public void handleUnexpectedException() {
        Exception exception = new Exception(ERROR);
        CustomRestExceptionHandler test = new CustomRestExceptionHandler();
        ErrorDTO errorDTO = test.handleUnexpectedException(exception);
        assertEquals(errorDTO.getCode(), 500);
        assertEquals(errorDTO.getError(), ERROR);
        assertEquals(errorDTO.getDetail(), "Unexpected error: " + exception.toString());
    }
}