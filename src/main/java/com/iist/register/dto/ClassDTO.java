package com.iist.register.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassDTO {

    @JsonProperty
    private Long classId;

    @JsonProperty
    private String className;
    @JsonProperty
    private Integer totalStudents;

    @JsonProperty
    private Long accountId;

    public ClassDTO() {
    }

    public ClassDTO(
            long classId,
            String className,
            Integer totalStudents,
            Long accountId)
    {
        this.classId = classId;
        this.className = className;
        this.totalStudents = totalStudents;
        this.accountId = accountId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
