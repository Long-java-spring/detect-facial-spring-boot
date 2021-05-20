package com.iist.register.service;

import com.iist.register.dto.UserDTO;
import com.iist.register.entity.User;
import com.iist.register.exception.UserNameExistedException;
import com.iist.register.repository.UserRepository;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findFirstByUsernameIgnoreCase(userDTO.getUsername());
        if (existingUser.isPresent()) {
            logger.error("User already exit");
            throw new UserNameExistedException(userDTO.getUsername());
        }
        try {
            userRepository.save(new User(userDTO));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
