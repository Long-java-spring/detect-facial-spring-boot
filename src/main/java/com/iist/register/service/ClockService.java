package com.iist.register.service;

import com.iist.register.entity.Clock;
import com.iist.register.repository.ClockRepository;
import com.iist.register.security.AuthTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class ClockService {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private ClockRepository clockRepository;

    public void create(Long detectUserId, Integer percent) {
        Instant time = Instant.now().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        String detectTime = formatter.format(time);
        try {
            clockRepository.save(new Clock(detectTime, detectUserId, percent));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
