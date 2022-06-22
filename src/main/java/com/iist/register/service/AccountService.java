package com.iist.register.service;

import com.iist.register.dto.AccountDTO;
import com.iist.register.entity.Account;
import com.iist.register.exception.UserNameExistedException;
import com.iist.register.repository.AccountRepository;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private AccountRepository accountRepository;

    public void registerUser(AccountDTO userDTO) {
        Optional<Account> existingUser = accountRepository.findFirstByUsernameIgnoreCase(userDTO.getUsername());
        if (existingUser.isPresent()) {
            logger.error("User already exit");
            throw new UserNameExistedException(userDTO.getUsername());
        }
        try {
            accountRepository.save(new Account(userDTO));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
