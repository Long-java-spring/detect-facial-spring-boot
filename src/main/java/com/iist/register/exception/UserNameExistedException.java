package com.iist.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Account already existed")
public class UserNameExistedException extends RestClientException {

    public UserNameExistedException(String username) {
        super(String.format("Account already exist with username is %s", username));
    }
}
