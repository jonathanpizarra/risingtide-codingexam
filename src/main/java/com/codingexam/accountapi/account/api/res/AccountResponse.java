package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.Null;


public interface AccountResponse {

    @Schema(description = "Status code")
    int getTransactionStatusCode();

    @Schema(description = "Status message")
    String getTransactionStatusDescription();
}
