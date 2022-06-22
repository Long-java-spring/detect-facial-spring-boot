package com.iist.register.service;

import com.iist.register.entity.Account;
import com.iist.register.repository.AccountRepository;
import com.iist.register.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findFirstByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("Account Not Found with username: " + username));

        return UserDetailsImpl.build(account);
    }
}
