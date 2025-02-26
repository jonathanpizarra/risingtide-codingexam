package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SuccessCustomerRes implements CustomerRes{

    @Schema(description = "Name of customer")
    String customerName;

    @Schema(description = "Customer mobile number")
    String customerMobile;

    @Schema(description = "Valid customer email")
    String customerEmail;

    @Schema(description = "Customer address 1")
    String address1;

    @Schema(description = "Customer address 2")
    String address2;

    @Schema(description = "Savings list", implementation = SavingsRes.class)
    List<SavingsRes> savings;

    @Schema(description = "Status code")
    int transactionStatusCode;

    @Schema(description = "Status message")
    String transactionStatusDescription;

}
