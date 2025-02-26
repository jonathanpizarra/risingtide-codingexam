package com.codingexam.accountapi.account.api.model;

import com.codingexam.accountapi.account.api.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer_account")
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", length = 50)
    private String customerName;

    @Column(name = "customer_mobile", length = 20)
    private String customerMobile;

    @Column(name = "customer_email", length = 50)
    private String customerEmail;

    @Column(name = "address1", length = 100)
    private String address1;

    @Column(name = "address2", length = 100)
    private String address2;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;


}
