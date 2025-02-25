package com.codingexam.accountapi.account.api.model;

import com.codingexam.accountapi.account.api.enums.AccountType;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String customerName;

    @Column(length = 20)
    private String customerMobile;

    @Column(length = 50)
    private String customerEmail;

    @Column(length = 100)
    private String address1;

    @Column(length = 100)
    private String address2;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;


}
