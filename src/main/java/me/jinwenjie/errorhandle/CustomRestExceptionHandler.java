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
    public ResponseEntity<Object> handleCustomerException(CustomException e) {
        final ErrorDTO customError = new ErrorDTO(e.getCode(), e.getError());
        return new ResponseEntity<Object>(customError, new HttpHeaders(), e.getHttpStatus());
    }

    // handle unexpected error
    @ExceptionHandler()
    @ResponseBody
    public ResponseEntity<Object> handleUnexpectedException(Exception e) {
        final ErrorDTO unexpectedError = new ErrorDTO(500, e.getLocalizedMessage(), "Unexpected error: " + e);
        return new ResponseEntity<Object>(unexpectedError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle DAO error
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ResponseEntity<Object> handleDaoException(Exception e) {
        // the class name will show possible error
        final ErrorDTO daoError = new ErrorDTO(500, e.getClass().toString(), e);
        return new ResponseEntity<Object>(daoError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle http method error
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ErrorDTO methodError = new ErrorDTO(status.value(), "HttpRequestMethodNotSupported", e);
        return new ResponseEntity<Object>(methodError, new HttpHeaders(), status);
    }

}
