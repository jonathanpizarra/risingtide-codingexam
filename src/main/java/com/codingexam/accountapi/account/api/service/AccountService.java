package com.codingexam.accountapi.account.api.service;

import com.codingexam.accountapi.account.api.req.AccountRequest;

public interface AccountService {

     long createAccount(AccountRequest data);

     String findAccount(String data);
}
