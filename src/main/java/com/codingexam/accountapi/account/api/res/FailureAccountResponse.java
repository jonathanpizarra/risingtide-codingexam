package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.Null;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FailureAccountResponse implements AccountResponse{

    @Schema(description = "Status code")
    int transactionStatusCode;

    @Schema(description = "Status message")
    String transactionStatusDescription;

}
