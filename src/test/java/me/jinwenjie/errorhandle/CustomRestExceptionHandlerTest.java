package me.jinwenjie.errorhandle;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomRestExceptionHandlerTest {
    final Integer CODE = 1000;
    final String ERROR = "TEST ERROR";
    final HttpStatus STATUS = HttpStatus.OK;

    @Test
    public void handleCustomerException() {
        // from enum
        CustomException customError = new CustomException(ExceptionEnum.USER_ACCOUNT_WRONG);
        CustomRestExceptionHandler test = new CustomRestExceptionHandler();
        ResponseEntity<Object> result = test.handleCustomerException(customError);
        ErrorDTO errorDTO = (ErrorDTO) result.getBody();
        assert errorDTO != null;
        assertEquals(ExceptionEnum.USER_ACCOUNT_WRONG.getCode(), errorDTO.getCode());
        assertEquals(ExceptionEnum.USER_ACCOUNT_WRONG.getError(), errorDTO.getError());
        assertEquals(ExceptionEnum.USER_ACCOUNT_WRONG.getHttpStatus(), result.getStatusCode());
        assertNull(errorDTO.getDetail());
        // from custom
        customError.setCode(CODE);
        customError.setError(ERROR);
        customError.setHttpStatus(STATUS);
        result = test.handleCustomerException(customError);
        errorDTO = (ErrorDTO) result.getBody();
        assert errorDTO != null;
        assertEquals(CODE, errorDTO.getCode());
        assertEquals(ERROR, errorDTO.getError());
        assertEquals(STATUS, result.getStatusCode());
        assertNull(errorDTO.getDetail());
    }

    @Test
    public void handleUnexpectedException() {
        Exception exception = new Exception(ERROR);
        CustomRestExceptionHandler test = new CustomRestExceptionHandler();
        ErrorDTO errorDTO = test.handleUnexpectedException(exception);
        assertEquals((Integer) 500, errorDTO.getCode());
        assertEquals(ERROR, errorDTO.getError());
        assertEquals("Unexpected error: " + exception, errorDTO.getDetail());
    }
}