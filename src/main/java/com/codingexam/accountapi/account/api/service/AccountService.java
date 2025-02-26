package com.codingexam.accountapi.account.api.service;

import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.res.CustomerRes;

public interface AccountService {

     long createAccount(AccountRequest data);

     CustomerRes findAccount(Long customerNumber);
}
