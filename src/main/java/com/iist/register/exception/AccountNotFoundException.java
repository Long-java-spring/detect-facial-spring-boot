package com.iist.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Account not exist")
public class AccountNotFoundException extends RestClientException {
    public AccountNotFoundException(Long accountId) {
        super(String.format("Account not exist with id is %s", accountId));
    }
}
