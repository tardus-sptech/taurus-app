package com.taurus.financeapi.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException validationException) {
        var details = new ExceptionDetails();
        details.setMessage(validationException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> handleValidationException(AuthException authException) {
        var details = new ExceptionDetails();
        details.setMessage(authException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.UNAUTHORIZED);
    }
}
