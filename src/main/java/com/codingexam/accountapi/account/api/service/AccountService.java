package com.codingexam.accountapi.account.api.service;

import com.codingexam.accountapi.account.api.req.AccountRequest;

public interface AccountService {

     int createAccount(AccountRequest data);

     String findAccount(String data);
}
