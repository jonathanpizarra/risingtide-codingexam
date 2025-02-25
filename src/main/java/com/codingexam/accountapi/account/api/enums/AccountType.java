package com.codingexam.accountapi.account.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum AccountType {
    S("Savings"),
    C("Checking");

    private final String accountType;
}
