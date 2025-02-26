package com.codingexam.accountapi.account.api.controller;

import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.res.AccountResponse;
import com.codingexam.accountapi.account.api.res.SuccessAccountResponse;
import com.codingexam.accountapi.account.api.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/account")
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<AccountResponse> createAccount(@Valid @ModelAttribute @Parameter(description = "Account data") AccountRequest accountRequest){
            long customerNumber = accountService.createAccount(accountRequest);
            AccountResponse accountResponse = new SuccessAccountResponse(customerNumber, HttpStatus.CREATED.value(), "Customer account created");
            return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<String> findAccount(@PathVariable @Parameter(description = "ID of user") String userId){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
