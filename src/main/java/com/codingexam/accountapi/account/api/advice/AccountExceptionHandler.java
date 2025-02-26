package com.codingexam.accountapi.account.api.advice;

import com.codingexam.accountapi.account.api.exception.CustomerNotFoundException;
import com.codingexam.accountapi.account.api.res.AccountResponse;
import com.codingexam.accountapi.account.api.res.CustomerRes;
import com.codingexam.accountapi.account.api.res.FailureAccountResponse;
import com.codingexam.accountapi.account.api.res.FailureCustomerRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleCustomerNumberValidationExceptions(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("Customer Number must be numeric", HttpStatus.BAD_REQUEST); //
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomerRes> handleCustomerNotFoundException(CustomerNotFoundException ex){
        CustomerRes customerRes = new FailureCustomerRes(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(customerRes, HttpStatus.UNAUTHORIZED);
    }

}
