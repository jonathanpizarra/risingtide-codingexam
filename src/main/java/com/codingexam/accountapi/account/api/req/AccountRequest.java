package com.codingexam.accountapi.account.api.req;

import com.codingexam.accountapi.account.api.enums.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class AccountRequest {

    @Schema(description = "Name of customer", required = true)
    @Size(max = 50, message = "Customer name is too long")
    String customerName;

    @Schema(description = "Customer mobile number", required = true)
    @Size(max = 20, message = "Mobile number is too long")
    String customerMobile;

    @Schema(description = "Valid customer email", required = true)
    @Email(message = "Email is required field")
    String customerEmail;

    @Schema(description = "Customer address 1", required = true)
    @Size(max = 100, message = "Address is too long")
    String address1;

    @Schema(description = "Customer address 2")
    @Size(max = 100, message = "Address 2 is too long")
    String address2;

    @Schema(description = "Account type", required = true)
    AccountType accountType;

}
