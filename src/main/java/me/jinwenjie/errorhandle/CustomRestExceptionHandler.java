package me.jinwenjie.errorhandle;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    // handle custom error
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomerException(CustomException ex) {
        final ErrorDTO customError = new ErrorDTO(ex.getCode(), ex.getError());
        return new ResponseEntity<Object>(customError, new HttpHeaders(), ex.getHttpStatus());
    }

    // handle unexpected error
    @ExceptionHandler()
    @ResponseBody
    public ErrorDTO handleUnexpectedException(Exception e) {
        return new ErrorDTO(500, e.getLocalizedMessage(), "Unexpected error: " + e.toString()
        );
    }

    // handle DAO error
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ErrorDTO handleDaoException(Exception e) {
        return new ErrorDTO(500, e.getClass().toString(), e.toString());
    }

    // handle http method error
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ErrorDTO methodError = new ErrorDTO(status.value(), "HttpRequestMethodNotSupported", e.toString());
        return new ResponseEntity<Object>(methodError, new HttpHeaders(), status);
    }

}
