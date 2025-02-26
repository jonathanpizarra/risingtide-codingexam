package com.codingexam.accountapi.account.api.service.impl;

import com.codingexam.accountapi.account.api.enums.AccountType;
import com.codingexam.accountapi.account.api.exception.CustomerNotFoundException;
import com.codingexam.accountapi.account.api.model.CustomerAccount;
import com.codingexam.accountapi.account.api.repository.AccountRepository;
import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.res.CustomerRes;
import com.codingexam.accountapi.account.api.res.SavingsRes;
import com.codingexam.accountapi.account.api.res.SuccessCustomerRes;
import com.codingexam.accountapi.account.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        CustomerAccount customerAccount = mapToEntity(data);
        CustomerAccount newCustomerAccount = accountRepository.save(customerAccount);

        return newCustomerAccount.getId();
    }

    @Override
    public CustomerRes findAccount(Long customerNumber) {
        Optional<CustomerAccount> account = accountRepository.findById(customerNumber);
        if(account.isPresent()){
            return mapToResponse(account.get());
        }
        throw new CustomerNotFoundException("Customer not found");
    }


    private CustomerAccount mapToEntity(AccountRequest data){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomerName(data.getCustomerName());
        customerAccount.setCustomerMobile(data.getCustomerMobile());
        customerAccount.setCustomerEmail(data.getCustomerEmail());
        customerAccount.setAddress1(data.getAddress1());
        if(!data.getAddress2().trim().isEmpty()){
            customerAccount.setAddress2(data.getAddress2());
        }
        customerAccount.setAccountType(AccountType.valueOf(data.getAccountType()));
        return customerAccount;
    }

    private CustomerRes mapToResponse(CustomerAccount customerAccount){
        SuccessCustomerRes customer = new SuccessCustomerRes();
        customer.setCustomerName(customerAccount.getCustomerName());
        customer.setCustomerMobile(customerAccount.getCustomerMobile());
        customer.setCustomerEmail(customerAccount.getCustomerEmail());
        customer.setAddress1(customerAccount.getAddress1());
        customer.setAddress2(customerAccount.getAddress2());

        SavingsRes savings = new SavingsRes();
        savings.setAccountType(customerAccount.getAccountType().accountType);

        List<SavingsRes> savingsResList = new ArrayList<>();
        savingsResList.add(savings);
        customer.setSavings(savingsResList);

        return customer;
    }
}
