package com.codingexam.accountapi.account.api.service.impl;

import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public int createAccount(AccountRequest data) {
        System.out.println(data.getCustomerName());
        System.out.println(data.getAccountType());
        System.out.println(data.getCustomerEmail());
        return 42;
    }

    @Override
    public String findAccount(String data) {
        return "";
    }
}
