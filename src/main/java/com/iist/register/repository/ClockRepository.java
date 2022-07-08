package com.iist.register.repository;

import com.iist.register.entity.Clock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ClockRepository extends JpaRepository<Clock, Long> {

    @Query(value ="SELECT MAX(c.detectTime) FROM Clock c " +
            "WHERE c.detectUserId = :userId " +
            "AND :startTime <= c.createdDate " +
            "AND c.createdDate < :endTime ")
    String getMostRecentDetectTime(
        @Param("userId") Long userId,
        @Param("startTime") LocalDateTime startTime,
        @Param("endTime") LocalDateTime endTime
    );
}
