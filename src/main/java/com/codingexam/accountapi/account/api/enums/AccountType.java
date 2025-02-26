package com.codingexam.accountapi.account.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
    S("Savings"),
    C("Checking");

    public final String accountType;
}
