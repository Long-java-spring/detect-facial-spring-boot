package com.iist.register.controller;

import com.iist.register.dto.AccountDTO;
import com.iist.register.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService userService;

    public AccountController(AccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AccountDTO userDTO) {
        userService.registerUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
