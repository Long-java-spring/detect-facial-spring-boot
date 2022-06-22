package com.iist.register.service;

import com.iist.register.dto.ClassDTO;
import com.iist.register.entity.Account;
import com.iist.register.entity.Class;
import com.iist.register.exception.AccountNotFoundException;
import com.iist.register.repository.AccountRepository;
import com.iist.register.repository.ClassRepository;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void create(ClassDTO classDTO) {
        Optional<Account> accountOptional = accountRepository.findById(classDTO.getAccountId());
        if (!accountOptional.isPresent()) {
            throw new AccountNotFoundException(classDTO.getAccountId());
        }
        try {
            classRepository.save(new Class(classDTO));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
