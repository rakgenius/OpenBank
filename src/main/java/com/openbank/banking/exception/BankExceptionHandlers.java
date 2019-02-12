package com.openbank.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ControllerAdvice
public class BankExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BankException.class)
    public ResponseEntity handleBankExeption(final BankException e) {
        ErrorResponse errorResponse = ErrorResponse.of(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }
}
