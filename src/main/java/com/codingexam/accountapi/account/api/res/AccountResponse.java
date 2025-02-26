package com.codingexam.accountapi.account.api.res;

import io.swagger.v3.oas.annotations.media.Schema;

public interface AccountResponse {

    @Schema(description = "Status code")
    int getTransactionStatusCode();

    @Schema(description = "Status message")
    String getTransactionStatusDescription();
}
