package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingsRes {

    @Schema(description = "Savings account number")
    Long accountNumber;

    @Schema(description = "Savings account type")
    String accountType;

    @Schema(description = "Savings account available balance")
    BigDecimal availableBalance;


}
