package com.iist.register.exception;

import org.springframework.web.client.RestClientException;

public class UserNameExistedException extends RestClientException {

    public UserNameExistedException(String username) {
        super(String.format("User already exit with username is %s", username));
    }
}