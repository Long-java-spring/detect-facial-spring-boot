package com.iist.register.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Clocks")
public class Clock {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "detect_time")
    private String detectTime;
    @Column(name = "detect_user_id")
    private Long detectUserId;
    @Column(name = "actual_user_id")
    private Long actualUserId;
    @Column(name = "percent")
    private Integer percent;
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Clock() {
    }

    public Clock(
            String detectTime,
            Long detectUserId,
            Integer percent
    ) {
        this.detectTime = detectTime;
        this.detectUserId = detectUserId;
        this.actualUserId = null;
        this.percent = percent;
        this.createdDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(String detectTime) {
        this.detectTime = detectTime;
    }

    public Long getDetectUserId() {
        return detectUserId;
    }

    public void setDetectUserId(Long detectUserId) {
        this.detectUserId = detectUserId;
    }

    public Long getActualUserId() {
        return actualUserId;
    }

    public void setActualUserId(Long actualUserId) {
        this.actualUserId = actualUserId;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
