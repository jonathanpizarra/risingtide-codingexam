package com.codingexam.accountapi.account.api.service;

import com.codingexam.accountapi.account.api.enums.AccountType;
import com.codingexam.accountapi.account.api.exception.CustomerNotFoundException;
import com.codingexam.accountapi.account.api.model.CustomerAccount;
import com.codingexam.accountapi.account.api.repository.AccountRepository;
import com.codingexam.accountapi.account.api.req.AccountRequest;
import com.codingexam.accountapi.account.api.res.SuccessCustomerRes;
import com.codingexam.accountapi.account.api.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AccountServiceImplTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCustomerAccountTest(){
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setCustomerName("test");
        accountRequest.setCustomerMobile("123");
        accountRequest.setCustomerEmail("mail@email.com");
        accountRequest.setAddress1("test");
        accountRequest.setAccountType("C");

        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setId(1L);
        customerAccount.setCustomerName("test");
        customerAccount.setCustomerMobile("123");
        customerAccount.setCustomerEmail("mail@email.com");
        customerAccount.setAddress1("test");
        customerAccount.setAccountType(AccountType.C);

        when(accountRepository.save(any(CustomerAccount.class))).thenReturn(customerAccount);

        Long customerNumber = accountService.createAccount(accountRequest);

        assertNotNull(customerNumber);
        assertEquals(1L, customerNumber);
        verify(accountRepository, times(1)).save(any(CustomerAccount.class));
    }

    @Test
    void findCustomerAccountTest(){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setId(1L);
        customerAccount.setCustomerName("test");
        customerAccount.setCustomerMobile("123");
        customerAccount.setCustomerEmail("mail@email.com");
        customerAccount.setAddress1("test");
        customerAccount.setAccountType(AccountType.C);

        when(accountRepository.findById(any())).thenReturn(Optional.of(customerAccount));

        SuccessCustomerRes customerRes = (SuccessCustomerRes) accountService.findAccount(1L);

        assertNotNull(customerRes);
        assertEquals("test", customerRes.getCustomerName());
        assertEquals(1, customerRes.getSavings().size());
        assertEquals("Checking", customerRes.getSavings().get(0).getAccountType());
    }

    @Test
    void findCustomerAccountTest_Failure(){

        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class, () -> {
            accountService.findAccount(any());
        });

        assertEquals("Customer not found", exception.getMessage());
    }



}
