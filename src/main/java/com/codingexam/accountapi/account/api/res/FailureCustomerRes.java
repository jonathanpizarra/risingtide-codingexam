package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FailureCustomerRes implements CustomerRes{

    @Schema(description = "Status code")
    int transactionStatusCode;

    @Schema(description = "Status message")
    String transactionStatusDescription;
}
