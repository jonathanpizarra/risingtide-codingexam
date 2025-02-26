package com.codingexam.accountapi.account.api.service.impl;

import com.codingexam.accountapi.account.api.enums.AccountType;
import com.codingexam.accountapi.account.api.model.Account;
import com.codingexam.accountapi.account.api.repository.AccountRepository;
import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public long createAccount(AccountRequest data) {
        System.out.println(data.getCustomerName());
        System.out.println(data.getAccountType());
        System.out.println(data.getCustomerEmail());
        Account account = mapToEntity(data);
        Account newAccount = accountRepository.save(account);

        return newAccount.getId();
    }

    @Override
    public String findAccount(String data) {
        return "";
    }


    private Account mapToEntity(AccountRequest data){
        Account account = new Account();
        account.setCustomerName(data.getCustomerName());
        account.setCustomerMobile(data.getCustomerMobile());
        account.setCustomerEmail(data.getCustomerEmail());
        account.setAddress1(data.getAddress1());
        if(!data.getAddress2().trim().isEmpty()){
            account.setAddress2(data.getAddress2());
        }
        account.setAccountType(AccountType.valueOf(data.getAccountType()));
        return account;
    }
}
