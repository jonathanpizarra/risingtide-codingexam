package com.codingexam.accountapi.account.api.advice;

import com.codingexam.accountapi.account.api.res.AccountResponse;
import com.codingexam.accountapi.account.api.res.FailureAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AccountExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseEntity<AccountResponse> handleValidationExceptions(BindException ex) {
        List<String> errors = new ArrayList<>();
        System.out.println("handling errors ...");
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        System.out.println(errors);
        System.out.println("....errors");
        AccountResponse accountResponse = new FailureAccountResponse(HttpStatus.BAD_REQUEST.value(), errors.get(0));
        return new ResponseEntity<>(accountResponse, HttpStatus.BAD_REQUEST);
    }

}
